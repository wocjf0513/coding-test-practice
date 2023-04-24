import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔{


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());

        int c=Integer.parseInt(st.nextToken());

        long[] dp=new long[1101];
        int n=Integer.parseInt(st.nextToken());

        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int cost=Integer.parseInt(st.nextToken());
            int customer=Integer.parseInt(st.nextToken());
            dp[customer]=Math.min(dp[customer],cost);
        }

        long min=Long.MAX_VALUE;

        for(int i=2; i<=1100; i++){
            
            for(int j=1; j<=i/2; j++){
                dp[i]=Math.min(dp[i-j]+dp[j],dp[i]);
            }
            if(i>=c)
            {
                if(dp[i]<min)
                min=dp[i];
            }
        }

        if(c==1)
        min=Math.min(dp[1],min);
        
        System.out.println(min);
        
    
    }
}