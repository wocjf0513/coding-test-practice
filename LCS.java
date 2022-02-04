import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LCS {
    static String s1;
    static String s2;
    
    static int max_count=0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        s1=br.readLine();
        s2=br.readLine();

        int[][] dp=new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++)
        {
            for(int j=1; j<=s2.length(); j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

                if(dp[i][j]>max_count)
                max_count=dp[i][j];

            }
        }
        System.out.println(max_count);
    }

    //각 문자열 S1 과 S2로 테이블 구성
    //   S A K
    // V 0 0 0
    // A 0 0 0 

}
