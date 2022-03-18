import java.util.Scanner;

public class 타일채우기 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        int answer = 0;
        if (n % 2 == 1) {
            answer = 0;
        } 
        else {
            dp[0] = 1;
            dp[2] = 3;
            for(int i=4; i<=n; i++)
            {
                dp[i]=dp[i-2]*dp[2];
                for(int j=i-4; j>=0; j-=2)
                {
                    dp[i]+=dp[j]*2;
                }
            }
    
            answer=dp[n];
        }

       
         

        System.out.println(answer);
        sc.close();
    }
}
 
