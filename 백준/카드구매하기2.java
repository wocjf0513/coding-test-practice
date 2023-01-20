import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기2{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        int[] pList=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            pList[i]=Integer.parseInt(st.nextToken());
        }
        //카드 N개를 갖기 위해 지불해야 하는 금액의 최솟값

        int dp[][]=new int[n+1][n+1]; 

        Arrays.fill(dp[0],Integer.MAX_VALUE);

        //i는 카드팩의 종류, j는 필요 개수
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i>j){
                    //필요 카드가 적을 때
                    dp[i][j]=dp[i-1][j];
                }
                else if(i==j){
                    //필요 카드 개수와 같을 때
                    dp[i][j]=pList[i];
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j]);
                }
                else{
                    //i<j
                        dp[i][j]=Math.min(dp[i][j-i]+pList[i],dp[i-1][j]);
                }
            }
        }
        //카드를 버리는 경우는 불가능.

        System.out.println(dp[n][n]);

        


    }
}