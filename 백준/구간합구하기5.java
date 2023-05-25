import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기5 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        
        int dp[][]=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            int sum=0;
            
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                sum+=Integer.parseInt(st.nextToken());
                dp[i][j]=sum;
            }
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            int sum=0;


            for(int j=x1; j<=x2; j++){
                sum+=dp[j][y2]-dp[j][y1-1];
            }
            bw.append(Integer.toString(sum)+"\n");
        }
        
        bw.close();
        br.close();
    }
    
    
}
