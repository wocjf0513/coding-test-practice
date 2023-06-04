import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[][] house=new int[n][n];

        int[][][] dp=new int[n][n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                house[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        // 입력 - 0 번 인덱스부터

        // 알고리즘 - (n-1, n-1) 인덱스로 가게 해야한다.
        // 오른쪽 아래 오른쪽 아래 대각선
        // 할 수 있는 방법의 개수

        dp[0][1][0]=1; //0은 오른쪽

        class Point{
            private int y;
            private int x;
            Point(int y, int x){
                this.y=y;
                this.x=x;
            
            }
            public boolean check(){
                if(x<0 || y<0 || x>=n || y>=n)
                return false;

                return true;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Point pl=new Point(i,j-1); //왼쪽
                Point pu=new Point(i-1,j); //위쪽
                Point pd=new Point(i-1,j-1); //왼쪽 위

                //0은 오른쪽 1은 대각선 2는 아래
                if(pl.check() && house[pl.y][pl.x]==0 && house[i][j]==0){
            
                    dp[i][j][0]+=dp[pl.y][pl.x][0];
                    dp[i][j][0]+=dp[pl.y][pl.x][1];

                }
                if(pu.check()  && house[pu.y][pu.x]==0 && house[i][j]==0) {
        
                    dp[i][j][2]+=dp[pu.y][pu.x][1];
                    dp[i][j][2]+=dp[pu.y][pu.x][2];
                }
                if(pd.check() && pu.check() && pd.check()  && house[pd.y][pd.x]==0 && house[pl.y][pl.x]==0 && house[pu.y][pu.x]==0  && house[i][j]==0 ){
                    //대각선

                    dp[i][j][1]+=dp[pd.y][pd.x][0];
                    dp[i][j][1]+=dp[pd.y][pd.x][1];
                    dp[i][j][1]+=dp[pd.y][pd.x][2];
                }
            }
        }

        int ans=0;

        for(int i=0; i<3; i++){
            ans+=dp[n-1][n-1][i];
        }

        System.out.println(ans);


    }
    
}
