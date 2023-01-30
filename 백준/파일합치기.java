import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 파일합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            int[] input=new int[n+1];
            int dp[][]=new int[n+1][n+1];
            int sum[]=new int[n+1];

            

            for(int i=1; i<=n; i++){
                input[i]=(Integer.parseInt(st.nextToken()));
                sum[i]=sum[i-1]+input[i]; //어차피 더해지는 과정이 있어야 하므로
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j+i<=n; j++){
                    dp[j][j+i]=Integer.MAX_VALUE;
                    for(int k=j; k<j+i; k++){
                        dp[j][j+i]=Math.min(dp[j][j+i],dp[j][k]+dp[k+1][j+i]+sum[j+i]-sum[j-1]);
                
                    }
                    
                }
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }

            bw.append(dp[1][n]+"\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
