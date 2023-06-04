import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.imageio.ImageReadParam;

public class 격자상의경로 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[][] dp=new int[n+1][m+1];

        int y=1;
        int x=1;

        if(k!=0){
        y=(k/m)+1;
        x=(k%m);

        if(x==0){
            x=m;
            y--;
        }
        
        }
        //격자의 위치 

        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                if(i==1 && j==1)
                dp[i][j]=1;
                else if(i==1){
                    dp[i][j]+=dp[i][j-1];
                }
                else if(j==1){
                    dp[i][j]+=dp[i-1][j];
                }
                else{
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];
                }
            }
        }


       
        int ans=dp[y][x];


        for(int i=y; i<=n; i++){
            for(int j=x; j<=m; j++){
                if(i==y && j==x)
                dp[i][j]=1;
                else if(i==y){
                    dp[i][j]+=dp[i][j-1];
                }
                else if(j==x){
                    dp[i][j]+=dp[i-1][j];
                }
                else{
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        ans=ans*dp[n][m];

        System.out.println(ans);



    }
}
