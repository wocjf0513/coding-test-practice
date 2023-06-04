import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡먹는호랑이 {


    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int d=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int dp[]=new int[d+1];
        dp[d]=k;

        int cnt=1;
        
        for(int i=k-1; i>=1; i--){
            cnt=1;
            for(int j=d-1; j>=1; j--){
                if(cnt==1)
                dp[j]=i;
                else{
                    dp[j]=dp[j+2]-dp[j+1];
                }
                if(dp[j]<1 || dp[j]>=dp[j+1])
                break;
                cnt++;
            }
            if(dp[1]>=1 && dp[1]<=dp[2]){
                System.out.println(dp[1]+"\n"+dp[2]);
            break;
            }
        }

    }
    
}
