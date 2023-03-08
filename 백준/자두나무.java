import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 자두나무 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());

        int dp[][]=new int[t+1][w+1];
        //홀수면 2에 위치
        //짝수면 1에 위치

        for(int i=1; i<=t; i++){
            int point=Integer.parseInt(br.readLine());
            for(int j=0; j<=w; j++){
                if(j==0){
                    if(point==1)
                    dp[i][j]=1+dp[i-1][j];
                    else
                    dp[i][j]=dp[i-1][j];
                }
                else if(j%2==0){
                    //1에 위치
                    if(point==1){
                        dp[i][j]=Math.max(dp[i-1][j]+1,dp[i-1][j-1]+1);
                        //나무가 1일때
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j]);
                        //나무가 2일때
                    }
                }
                else{
                    if(point==2){
                        dp[i][j]=Math.max(dp[i-1][j]+1,dp[i-1][j-1]+1);
                    }
                    else{
                        dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j]);
                    }
                }
            }
        }
        System.out.println(Arrays.stream(dp[t]).max().getAsInt());

    }
}
