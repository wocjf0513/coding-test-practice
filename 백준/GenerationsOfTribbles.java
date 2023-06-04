import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class GenerationsOfTribbles {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        long dp[]=new long[68]; 

        int t=Integer.parseInt(br.readLine());

        while(t>0){
            int n=Integer.parseInt(br.readLine());
            if(dp[n]!=0){
                bw.append(dp[n]+"\n");
            }
            else{
                for(int i=0; i<=n; i++){
                    if(dp[i]!=0)
                    continue;
                    else{
                        if(i<2)
                        dp[i]=1;
                        else if(i==2)
                        dp[i]=2;
                        else if(i==3)
                        dp[i]=4;
                        else
                        dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
                    }
                }
                bw.append(dp[n]+"\n");
            }
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
