import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크리보드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        long dp[]=new long[n+1];

        for(int i=1; i<=n; i++){
            dp[i]=dp[i-1]+1;

            for(int j=1; j+2<i; j++){
                long temp=dp[i-(j+2)]*(j+1);
                dp[i]=Math.max(dp[i],temp);
            }
        }
        
        System.out.println(dp[n]);

    }
    
}
