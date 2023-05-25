import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장큰정사각형 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] dp=new int[n][m];
        

        for(int i=0; i<n; i++){
            String s=br.readLine();
            for(int j=0; j<m; j++){
                dp[i][j]=s.charAt(j)-'0';
            }
        }

        if(n==1 && m==1){
            if(dp[0][0]==1){
            System.out.println(1);
            return;
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int newY=i-1;
                int newX=j-1;

                if(0<=newY && newY<n && 0<=newX && newX<m && dp[i][j]==1)
                {
                    int cnt=Math.min(dp[newY][j],dp[i][newX]);

                    while(cnt>0){
                        if(dp[i-cnt][j-cnt]>=1){
                            break;
                        }
                        cnt--;
                    }
                    dp[i][j]=Math.max(dp[i][j],cnt+1);
               
                }

                if(dp[i][j]>max)
                max=dp[i][j];
                //1. 위 왼쪽 숫자가 같은지 
                //2. 그 숫자만큼 대각선을 보기
                //3. 숫자를 줄여보면 대각선 보기
                //dp 정하기
                
            }
        }
        System.out.println(max*max);

    }
}
