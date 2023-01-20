import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 일이삼더하기5b {
    static long dp[][] = new long[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int max=3;
        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][3]=1;
        dp[3][1]=1;
        dp[3][2]=1;



        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n > max) {
                calDp(max, n);
                max = n;
            }
            long sum=0;

            for(int i=1; i<=3; i++)
            sum=(sum+dp[n][i])%1000000009;
            
            bw.append(sum + "\n");

            t--;
        }
        bw.flush();
        bw.close();

    }
    public static void calDp(int max, int target) {
        //1,000,000,009 나누기
        for (int i = max + 1; i <= target; i++) {
            dp[i][1]=(dp[i-1][2]+dp[i-1][3])%1000000009;
            dp[i][2]=(dp[i-2][3]+dp[i-2][1])%1000000009;
            dp[i][3]=(dp[i-3][1]+dp[i-3][2])%1000000009;
        }
    
    }
    
}
