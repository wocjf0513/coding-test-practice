import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇조종하기 {

    static int[][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        //왼, 오, 아
        //탐사 지역 또 가지 않는다.
        //(1,1) => (n,m)

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        map=new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //값 입력 
        //각 칸마다 최대 값을 찾는다.
        //int 형 사용 가능
        
        dp=new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            if(i==1){
                for(int j=1; j<=m; j++)
                dp[i][j]=map[i][j]+dp[i][j-1];
                
            }
            else{
                int temp[][]=new int[2][m+1];

                for(int j=1; j<=m; j++){
                    if(j==1)
                    temp[0][j]=map[i][j]+dp[i-1][j];
                    else
                    temp[0][j]=Math.max(map[i][j]+dp[i-1][j],map[i][j]+temp[0][j-1]);
                }

                for(int j=m; j>=1; j--){
                    if(j==m)
                    temp[1][j]=map[i][j]+dp[i-1][j];
                    else
                    temp[1][j]=Math.max(map[i][j]+dp[i-1][j],map[i][j]+temp[1][j+1]);
                }

                for(int j=1; j<=m; j++){
                    dp[i][j]=Math.max(temp[0][j],temp[1][j]);
                }


            }
        }
        System.out.println(dp[n][m]);


    }
}
