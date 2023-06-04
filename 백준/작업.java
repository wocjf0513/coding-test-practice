import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 작업{

    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int dp[]=new int[n+1];

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            
            int taskT=Integer.parseInt(st.nextToken());

            int pqN=Integer.parseInt(st.nextToken());

            for(int j=1; j<=pqN; j++){
                int pqT=Integer.parseInt(st.nextToken());
                dp[i]=Math.max(taskT+dp[pqT],dp[i]);
            }

            dp[i]=Math.max(dp[i],taskT);

            ans=Math.max(dp[i],ans);
        }

        System.out.println(ans);
        

    }
}