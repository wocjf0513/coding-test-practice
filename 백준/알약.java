import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 알약 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n=Integer.parseInt(br.readLine());
            if(n==0)
            break;

            long ans=0;
            //algorithm 진행

            long[][][] dp=new long[2*n+1][n+1][n+1];
            dp[0][n][0]=1;

            for(int i=0; i<2*n; i++){
                for(int j=0; j<=n; j++){
                    for(int k=0; k<=n; k++){
                        if(dp[i][j][k]!=0){
                            if(j-1>=0 && k+1<=n)
                            dp[i+1][j-1][k+1]+=dp[i][j][k];
                            if(k-1>=0)
                            dp[i+1][j][k-1]+=dp[i][j][k];
                        }
                    }
                }

            }
            
            ans=dp[2*n][0][0];

            bw.append(ans+"\n");
            

        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
