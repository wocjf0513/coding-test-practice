import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 파일합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            int[] input=new int[n+1];
            int dp[][]=new int[n+1][n+1];
            int sum[]=new int[n+1];

            

            for(int i=1; i<=n; i++){
                input[i]=(Integer.parseInt(st.nextToken()));
                sum[i]=sum[i-1]+input[i]; // 10 20 40 => 30 + 40== 30+ 70  or 10 + 60= 60 + 70 어차피 합이 있어야 되므로  
            }

            for(int i=2; i<=n; i++){
                for(int j=i-1; j>=1; j--){
                    dp[j][i]=Integer.MAX_VALUE;
                    for(int k=j; k<i; k++){
                        dp[j][i]=Math.min(dp[j][i],dp[j][k]+dp[k+1][i]);
                    }
                    dp[j][i]+=sum[i]-sum[j-1];
                }
            }
            

            bw.append(dp[1][n]+"\n");
            t--;
        }
        
            

        bw.flush();
        bw.close();
        br.close();
    }
    
}
