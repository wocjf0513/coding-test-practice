import java.util.Scanner;

public class 고층빌딩 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); int l=sc.nextInt(); int r=sc.nextInt();
        
        int dp[][][]=new int[n+1][n+1][n+1];

        dp[1][1][1]=1;
        dp[2][1][2]=1;dp[2][2][1]=1;

        
    }
    
}
