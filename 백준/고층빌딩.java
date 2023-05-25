import java.util.Scanner;

public class 고층빌딩 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); int  L=sc.nextInt(); int R=sc.nextInt();
        
        long dp[][][]=new long[N+1][N+1][N+1];

        dp[1][1][1]=1;
        
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                for(int k=1; k<=i; k++){
                    dp[i][j][k]=(dp[i-1][j-1][k]+dp[i-1][j][k-1]+dp[i-1][j][k]*(i-2))%1000000007;

                    //중간에 넣을 때 (i-1)의 경우의 수
                } 
            }
        }

        System.out.println(dp[N][L][R] % 1000000007);
    }
    
}
