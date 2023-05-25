import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 트리 {

    static int[] tree;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        tree=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            tree[i]=Integer.parseInt(st.nextToken());
        }

        int delN=Integer.parseInt(br.readLine());


        tree[delN]=-2;

        int rootTree=-1;

        for(int i=0; i<n; i++){
            if(tree[i]==delN)
            delTree(i,n);
            if(tree[i]==-1)
            rootTree=i;

            //삭제 노드를 가진 자식들
        }

        findLeaf(rootTree);
        //루트 노드로부터 리프 노드 찾기

        System.out.println(count);
        

    }
    public static void delTree(int index, int length){
        tree[index]=-2;
        //삭제 트리

        for(int i=0; i<length; i++)
        if(tree[i]==index){
        delTree(i, length);
        }

    }
    public static void findLeaf(int root){

        if(root==-1 || tree[root]==-2){
            return;
        }

        boolean find=true;

        for(int i=0; i<tree.length; i++)
        if(tree[i]==root){
        findLeaf(i);
        find=false;
        }

        if(find){
            count++;
            return ;
        }

    }

    //부모가 없으면 -1
    //자식들은 다 지워진다.
    //노드 -> 노드를 부모로 하는 애들 -> 반복

    
}
