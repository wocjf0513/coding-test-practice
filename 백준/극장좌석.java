import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 극장좌석{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        boolean[] site=new boolean[n+1];

        for(int i=1; i<=m; i++){
            site[Integer.parseInt(br.readLine())]=true;
        }
        //탐색 O(n)

        
        long[] dp=new long[n+1];
        dp[0]=1;

        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i]=1;
            }
            else if(site[i] || site[i-1]){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }

        System.out.println(dp[n]);
        
    }

}//자기 왼쪽 좌석이나 오른쪽 좌석에는 앉을 수 있다.