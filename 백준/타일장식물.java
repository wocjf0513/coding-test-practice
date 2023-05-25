import java.util.Scanner;

public class 타일장식물 {

    public static void main(String[] args) {
        long dp[]=new long[81];
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=1; i<=n; i++){
            if(i==1)
            dp[i]=1;
            else
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]*4+dp[n-1]*2);

    }
    
}
