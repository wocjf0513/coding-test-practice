import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일이삼더하기3 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        
        int t=Integer.parseInt(br.readLine());
        
        int input[] =new int[t+1];
        long dp[]=new long[1000001];

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        int max=Integer.MIN_VALUE;
        
        for(int i=1; i<=t; i++){
            input[i]=Integer.parseInt(br.readLine());
            if(max<input[i])
            max=input[i];
        }

        for(int i=4; i<=max; i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }
        
        for(int i=1; i<=t; i++){
            bw.append(dp[input[i]]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();


        


    }

    // 1 : 1 
    // 2 : 1 1 , 2
    // 3 : 1 1 1 , 2 1 , 1 2 , 3
    // 
}
