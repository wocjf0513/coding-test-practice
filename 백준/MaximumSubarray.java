import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSubarray {

    public static void main(String[] args)  throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());

        while(t>0){
            int n=Integer.parseInt(br.readLine());
            long dp[]=new long[n+1];
            dp[0]=-999;
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                int temp=Integer.parseInt(st.nextToken());
                dp[i]=Math.max(dp[i-1]+temp,temp);
            }
            bw.append(Arrays.stream(dp).max().getAsLong()+"\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
