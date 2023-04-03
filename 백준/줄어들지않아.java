import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 줄어들지않아 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        long[][] dp=new long[65][10];
        
        for(int i=0; i<=9; i++){
            dp[1][i]=1;
        }

        for(int i=2; i<=64; i++){
            for(int j=0; j<=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }
        

        while(t>0){
            int n=Integer.parseInt(br.readLine());
            long ans=0;
            for(long l:dp[n]){
                ans+=l;
            }
            bw.append(ans+"\n");
            t--;
        }

        bw.flush();bw.close();br.close();
    }
    
}
