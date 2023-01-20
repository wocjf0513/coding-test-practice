import java.util.Scanner;

public class 합분해 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        long dp[][]=new long[k+1][n+1];
        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                if(i==1)
                dp[i][j]=1;

                else{
                    for(int l=0; l<=j; l++){
                        dp[i][j]=(dp[i][j]+=dp[i-1][l])%1000000000;
                    }
                }
            }
        }

        System.out.println(dp[k][n]);
    }
    
}
