import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {

    static long[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        board=new long[n+1][n+1];
        long[][] dp=new long[n+1][n+1];

        StringTokenizer st;
        for(int i=1; i<=n; i++){
        st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //입력 받기

        dp[1][1]=1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){

                for(int k=1; k<j; k++){
                    if(j==board[i][k]+k)
                    dp[i][j]+=dp[i][k];

                }
                //왼쪽

                for(int k=1; k<i; k++){
                    if(i==board[k][j]+k)
                    dp[i][j]+=dp[k][j];
                }
                //위쪽
            }
        }
        System.out.println(dp[n][n]);




        
    }
    //가장 왼쪽 위=> 오른쪽 아래 
    
}
