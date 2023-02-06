import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사회망서비스 {

    static class Node{
        int num;
        ArrayList<Node> childs;


        Node(int i){
            num=i;
            childs=new ArrayList<>();
        }
    }

    static Node[] nodes;
    static int[][] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        check=new boolean[n+1];
        dp=new int[n+1][2];
        //idx 0은 얼리어답터가 아닐 때, idx 1은 얼리어답터일때

        nodes=new Node[n+1];
        
        for(int i=1; i<=n; i++){
            nodes[i]=new Node(i);
        }

        for(int i=1; i<=n-1; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            nodes[Integer.parseInt(st.nextToken())].childs.add(nodes[Integer.parseInt(st.nextToken())]);
        }

        dfs(1);
        long ans=Math.min(dp[1][0],dp[1][1]);
        System.out.println(ans);

    }
    public static void dfs(int cur){
        
        dp[cur][0]=0;
        dp[cur][1]=1;
        check[cur]=true;

        for(Node node:nodes[cur].childs){

            int tempCur=node.num;

            if(!check[tempCur]){
            dfs(tempCur);
            dp[cur][0]+=dp[tempCur][1];
            dp[cur][1]+=Math.min(dp[tempCur][0],dp[tempCur][1]);
            }
        }
        
    }
}


/**
 *         1
 *      2       3
 *    4        5  6
 *  7 8 9
 */
   
 

                
