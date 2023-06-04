import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int dp[][][]=new int[101][10][1024];
        dp[1][1][2]=1;
        dp[1][2][4]=1;
        dp[1][3][8]=1;
        dp[1][4][16]=1;
        dp[1][5][32]=1;
        dp[1][6][64]=1;
        dp[1][7][128]=1;
        dp[1][8][256]=1;
        dp[1][9][512]=1;

        long mod=1000000000;

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=1; k<1024; k++){
                    if(j!=0 && j!=9){
                    dp[i][j][((int)Math.pow(2,j)|k)]+=dp[i-1][j-1][k]%mod;
                    dp[i][j][((int)Math.pow(2,j)|k)]+=dp[i-1][j+1][k]%mod;
                    }
                    else if(j==0)
                    dp[i][j][((int)Math.pow(2,j)|k)]+=dp[i-1][j+1][k]%mod;
                    else
                    dp[i][j][((int)Math.pow(2,j)|k)]+=dp[i-1][j-1][k]%mod;
                }
            }
        }
    
    long ans=0; 

    for(int i=0; i<=9; i++){
        ans+=dp[n][i][1023];
    }
    System.out.println(ans%mod);
    }
    //전체를 돌면서 1부터 9까지 모두 포함되어있는지.
    //계단수인지
    
}
