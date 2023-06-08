import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class 뱀 {
    static int[] dir=new int[]{0,0,-1,1};
    static int n;

    public static void main(String[] args) throws IOException {
        //벽이나 자기 자신한테 부딪히면 끝
        //사과 먹으면 길이 늘어난다.
        //뱀은 0,0 위치 초반 길이는 1 뱀은 오른쪽 방향
        //이동 할때, 머리부터 이동
        //칸에 사과가 있으면, 꼬리 안 움직임
        // 없으면 꼬리 칸 빔

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); //보드 길이
        int[][] map=new int[n+1][n+1];
        int k=Integer.parseInt(br.readLine()); //사과의 개수

        for(int i=0; i<k; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int R=Integer.parseInt(st.nextToken());
            int C=Integer.parseInt(st.nextToken());

            map[R][C]=4; //4는 사과
        }
        
        char[] timeInform=new char[100001];

        int l=Integer.parseInt(br.readLine()); //방향전환 횟수
        
        for(int i=0; i<l; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken())+1;
            char c=st.nextToken().charAt(0);
            timeInform[x]=c;
        }

        int snakeR=1;
        int snakeC=1;
        int snakeD=0;

        Deque<int[]> dq=new LinkedList<>();
        dq.add(new int[]{1,1});
        
        //뱀의 지나간 자리 정보가 필요하다.
        for(int i=1; i<=10000; i++){
                if(timeInform[i]=='L'){
                    //왼쪽
                    if(snakeD==0){
                        //오른쪽
                        snakeD=2;
                    }
                    else if(snakeD==1){
                        //왼쪽
                        snakeD=3;
                    }
                    else if(snakeD==2){
                        //위에
                        snakeD=1;
                    }
                    else{
                        //밑에
                        snakeD=0;
                    }
                }
                else if(timeInform[i]=='D'){
                    //오른쪽
                    if(snakeD==0){
                        snakeD=3;
                    }
                    else if(snakeD==1){
                        snakeD=2;
                    }
                    else if(snakeD==2){
                        snakeD=0;
                    }
                    else{
                        snakeD=1;
                    }

                }
                //방향 정환
            int newR=snakeR+dir[snakeD];
            int newC=snakeC+dir[3-snakeD];
            
            if(newR<=0 || newC<=0 || newR> n || newC>n ){
                //벽에 부딪히거나 자기 몸에 부딪히면 끝
                //******오브젝트라 안될 수도 일단 해보자
                System.out.println(i);
                break;
            }

            if(contains(dq, newR, newC)){
                //몸에 부딪히는지 비교해야됨..
                System.out.println(i);
                break;
            }
            
            snakeR=newR;
            snakeC=newC;

            dq.add(new int[]{newR,newC});

            if(map[newR][newC]!=4){
                dq.poll();
            }
            else{
                map[newR][newC]=0;
            }    

        }
    }
    public static boolean contains(Deque<int[]> dq, int R, int C){
        java.util.Iterator<int[]> it=dq.iterator();

        while(it.hasNext()){
            int[] temp=it.next();
            if(temp[0]==R && temp[1]==C){
                return true;
            }
        }

        return false;
        

    }
    
}
