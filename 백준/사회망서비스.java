import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사회망서비스 {

    static class Node{
        ArrayList<Integer> link=new ArrayList<>();

        
    }

    static Node[] tree;
    static int dp[][];
    static boolean[] check; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        tree=new Node[n+1];
        dp=new int[n+1][2];
        check=new boolean[n+1];

        for(int i=1; i<=n; i++){
            tree[i]=new Node();
        }
        
        StringTokenizer st;

        for(int i=1; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int one=Integer.parseInt(st.nextToken());
            int two=Integer.parseInt(st.nextToken());

            tree[one].link.add(two);
            tree[two].link.add(one);
        }
        search(1);

        System.out.println(Math.min(dp[1][0],dp[1][1]));
        //최대 두개
    }
    public static void search(int nodeNum){


        dp[nodeNum][0]=0; //얼리어답터가 아닐때
        dp[nodeNum][1]=1; //얼리어답터

        check[nodeNum]=true;

        for(int n:tree[nodeNum].link){
            if(!check[n]){
            search(n);
            dp[nodeNum][0]+=dp[n][1];
            dp[nodeNum][1]+=Math.min(dp[n][0],dp[n][1]);
            }
        }
    }
}



