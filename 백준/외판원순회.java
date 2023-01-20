import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 외판원순회{

    //traveling salesman problem
    static int min=Integer.MAX_VALUE;
    static int n;
    static int[][] dp;
    static int[][] valueR;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        valueR=new int[n][n];
        dp=new int[n][1<<n]; //현재 위치, 방문한 곳
        //다 켜졌을때 1<<n-1
        
        //입력
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                valueR[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE );
        }


        dfs(0,1);

        System.out.println(min);
    
    }
    public static void dfs(int cur, int visited){
        
        if(visited==(1<<n)-1 && valueR[cur][0]!=0){
            min=Math.min(min,dp[cur][visited]+valueR[cur][0]);
            return;
        }

        for(int i=0; i<n; i++){
            int nextVisited=(visited|(1<<i));

            if(0==(visited&(1<<i)) && valueR[cur][i]!=0){
                if(dp[i][nextVisited]>dp[cur][visited]+valueR[cur][i]){
                    dp[i][nextVisited]=dp[cur][visited]+valueR[cur][i];
                    dfs(i,nextVisited);
                }
            }

        }

    }

}