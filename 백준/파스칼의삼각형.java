import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파스칼의삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[][]dp=new int[31][31];

        dp[1][1]=1;
        dp[2][1]=1; dp[2][2]=1;

        for(int i=3; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(j==1 || j==n)
                dp[i][j]=1;
                else{
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                if(i==n && j==k)
                    break;

                //양 끝 값은 무조건 1
                //각 행은 자기보다 1번째 작은 수 +  자기랑 같은 번째 수
            }
        }

        System.out.println(dp[n][k]);


    }
    
}
