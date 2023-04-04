import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병사배치하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        int soliders[]=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            soliders[i]=Integer.parseInt(st.nextToken());
        }

        int dp[]=new int[n];

        dp[0]=1;

        int max=0;

        for(int i=1; i<n; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(soliders[j]>soliders[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }                
            }
            
            if(max<dp[i]){
                max=dp[i];
            }
        }

        if(n!=1)
        System.out.println(n-max);
        else
        System.out.println(0);
    }
    
}
