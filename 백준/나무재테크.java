import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나무재테크{
    static int n,m,k; //n땅의 크기, m나무 개수, k 몇년 후의 나무 개수를 구할 것인지
    static PriorityQueue<Tree>[][] pq;
    static int[][] machine;
    static int[][] nutrtion;
    static int[] dirR=new int[]{-1,-1,-1,1,1,1,0,0};
    static int[] dirC=new int[]{1,-1,0,1,-1,0,1,-1};


    public static class Tree implements Comparable<Tree>{
        int tree_age;
        boolean alive;

        Tree(int a, boolean live){
            tree_age=a;
            alive=live;
        }

        @Override
        public int compareTo(Tree o) {
            return tree_age-o.tree_age;
        }


        

    }


    public static void main(String[] args) throws IOException {
        /* 입력 */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        machine=new int[n][n];        
        pq=new PriorityQueue[n][n];

        nutrtion=new int[n][n];


        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                machine[i][j]=Integer.parseInt(st.nextToken());
                pq[i][j]=new PriorityQueue<>();
                nutrtion[i][j]=5; //기본 5
            }
        }


        
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            int z=Integer.parseInt(st.nextToken());

            Tree newTree=new Tree(z,true);
            pq[x][y].add(newTree);
            //pq를 순회하면서 새로운 copy본을 하나 만들어 수정 후... pq에 반영할 예정
        }

        /* 알고리즘 */

        for(int ageCount=0; ageCount<k; ageCount++){
            /* 봄 */
            spring();
            /* 여름 */
            summer();
            /* 가을 */
            fall();
            /* 겨울 */
            winter();

        }
        long ans=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(Tree tempTree:pq[i][j]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void spring(){
        //봄 : 자신의 나이 만큼 양분먹는다. 나이는 1 증가 하나의 칸에 나이가 어린 나무부터 양분을 먹는다. 자신의 나이만큼 양분 못먹으면 죽는다.
        /* 봄 
        순회하면서, pq에 담긴 순서대로 
        if(나무의 나이 <= 땅 양분){
            땅 양분 먹고 나이 증가 
            땅 양분 그만큼 감소 
        }
            else{
                나무 데드 상태로 표시
            }
        */
        PriorityQueue<Tree>[][] newPq=new PriorityQueue[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newPq[i][j]=new PriorityQueue<>();
            }
        }
        

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(Tree tempTree:pq[i][j]){
                    Tree newTree=new Tree(tempTree.tree_age,tempTree.alive);

                    if(tempTree.tree_age<=nutrtion[i][j]){
                        nutrtion[i][j]=nutrtion[i][j]-newTree.tree_age;
                        newTree.tree_age=newTree.tree_age+1;
                    }
                    else{
                        newTree.alive=false;
                    }
                    newPq[i][j].add(newTree);
                }
            }
        }

        pq=newPq;

    }
    public static void summer(){
        //여름: 봄에 죽은 나무 -> 양분 , 죽은 나무의 나이/2 가 칸의 양분으로 추가됨.
        /* 순회하면서, 
         * for(tree:pq){
         * if(죽은 나무){
         * 죽은 나무의 나이/2 nutrtion에 추가
         * }
         * }
         */
        PriorityQueue<Tree>[][] newPq=new PriorityQueue[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newPq[i][j]=new PriorityQueue<>();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(Tree tempTree:pq[i][j]){
                    Tree newTree=new Tree(tempTree.tree_age, tempTree.alive);
                    if(!newTree.alive){
                        //죽은 나무
                        nutrtion[i][j]+=newTree.tree_age/2;
                    }
                    else{
                        //산 나무
                        newPq[i][j].add(newTree);
                    }
                }
            }
        }
        pq=newPq;
    }
    public static void fall(){
        //가을: 나무 번식, 번식 나무는 5의 배수, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.

        PriorityQueue<Tree>[][] newPq=new PriorityQueue[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newPq[i][j]=new PriorityQueue<>();
            }
        }

         for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(Tree tempTree:pq[i][j]){
                    Tree newTree=new Tree(tempTree.tree_age, tempTree.alive);
                    newPq[i][j].add(newTree);
                    if(tempTree.tree_age%5==0){
                        //번식 가능
                        for(int dirCount=0; dirCount<8; dirCount++){
                            int newR=i+dirR[dirCount];
                            int newC=j+dirC[dirCount];

                            if(0<=newR && 0<=newC && newR<n &&newC<n){
                                Tree localNewTree=new Tree(1,true);
                                newPq[newR][newC].add(localNewTree);
                            }
                        }
                        
                    }
                }
            }
        }

        pq=newPq;


    }
    public static void winter(){
        //겨울: 기계가 땅에 양분 추가 
        /*순회하면서 머신이 양분 추가! */
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                nutrtion[i][j]+=machine[i][j];
            }
        }
    }

}