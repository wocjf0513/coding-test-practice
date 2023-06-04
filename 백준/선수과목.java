import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선수과목 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[] dp=new int[n+1];

        boolean[][] input=new boolean[n+1][n+1];

        for(int i=1; i<=m; i++){
            st=new StringTokenizer(br.readLine());
            int pre=Integer.parseInt(st.nextToken());
            int cur=Integer.parseInt(st.nextToken());
            
            input[pre][cur]=true;
        }

        Arrays.fill(dp,1);

        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(input[i][j])
                dp[j]=Math.max(dp[i]+1,dp[j]);
            }
        }

        for(int i=1; i<=n; i++){
            System.out.print(dp[i]+" ");
        }



    }
    
}
