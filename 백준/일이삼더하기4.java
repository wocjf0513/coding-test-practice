import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일이삼더하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        int[][] dp=new int[10001][4];

        /**
         * 4 
         * 1 1 1 1
         * 2 1 1  , 2 2
         * 3 1
         */

        dp[1][1]=1; dp[1][2]=1; dp[1][3]=1;
        dp[2][1]=1; dp[2][2]=2; dp[2][3]=2;
        dp[3][1]=1; dp[3][2]=2; dp[3][3]=3;

    

        for(int i=4; i<=10000; i++){
            dp[i][1]=dp[i-1][1];
            dp[i][2]=dp[i-2][2]+dp[i-1][1];
            dp[i][3]=dp[i-3][3]+dp[i-2][2]+dp[i-1][1];
        }

        while(t>0){
            t--;
            int n=Integer.parseInt(br.readLine());
            bw.append(dp[n][3]+"\n");
        }

        bw.flush();
        bw.close();
    }

}

