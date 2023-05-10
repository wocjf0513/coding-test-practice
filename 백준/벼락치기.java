import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벼락치기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());

        int dp[][]=new int[n+1][t+1];
        
        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());

            if(k<=t)
            dp[i][k]=s;

                for(int j=1; j<=t; j++){
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    
                    if(j>k)
                    dp[i][j]=Math.max(dp[i][j],s+dp[i-1][j-k]);
        
                }
       
        }
        System.out.println(dp[n][t]);
    }
    
}
