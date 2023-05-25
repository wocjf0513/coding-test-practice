import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 앱 {
    
    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringTokenizer st2;

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        st2=new StringTokenizer(br.readLine());
        

        int memory[]=new int[n+1];
        int cost[]=new int[n+1];

        int sum=0;
        for(int i=1; i<=n; i++){
            memory[i]=Integer.parseInt(st.nextToken());
            cost[i]=Integer.parseInt(st2.nextToken());
            sum+=cost[i];
        }

        long dp[][]=new long[n+1][sum+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j<cost[i]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-cost[i]]+memory[i]);
                }
            }
        }

        long ans=Long.MAX_VALUE;

        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                System.out.print(dp[i][j]+" ");
                if(m<=dp[i][j])
                {
                    if(ans>j){
                        ans=j;
                    }
                }
            }
            System.out.println();
        }
        System.out.println(ans);
        


        

        


        
    }
}
