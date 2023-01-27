import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        class House{
            int red;
            int green;
            int blue;

            House(int r, int g, int b){
                red=r;
                green=g;
                blue=b;
            }
        }

        House[] hList=new House[n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            hList[i]=new House(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        // 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
        // N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
        // i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.

        long dp[][]=new long[n+1][3];

        long ans=0;
        
        for(int i=1; i<=n; i++){

            if(i==1){
            dp[i][0]=hList[i].red;
            dp[i][1]=1000*1000+1;
            dp[i][2]=1000*1000+1;
            }
            if(i!=1){
                dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+hList[i].red;
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+hList[i].green;
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+hList[i].blue;
            }

            if(i==n){
                ans=Math.min(dp[i][1],dp[i][2]);
            }

        }
        
        
        for(int i=1; i<=n; i++){

            if(i==1){
            dp[i][0]=1000*1000+1;
            dp[i][1]=hList[i].green;
            dp[i][2]=1000*1000+1;
            }
            if(i!=1){
                dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+hList[i].red;
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+hList[i].green;
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+hList[i].blue;
            }

            if(i==n){
                long localA=Math.min(dp[i][0],dp[i][2]);
                ans=Math.min(ans,localA);
            }
        }

         
        for(int i=1; i<=n; i++){

            if(i==1){
            dp[i][0]=1000*1000+1;
            dp[i][1]=1000*1000+1;
            dp[i][2]=hList[i].blue;
            }
            if(i!=1){
                dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+hList[i].red;
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+hList[i].green;
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+hList[i].blue;
            }

            if(i==n){
                long localA=Math.min(dp[i][0],dp[i][1]);
                ans=Math.min(localA,ans);
            }
        }

        System.out.println(ans);
        
        

    }
        //     3
        // 26 40 83
        // 49 60 57
        // 13 89 99
}
