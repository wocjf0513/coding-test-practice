import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class 동전{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());

        while(t>0){

            int n=Integer.parseInt(br.readLine());
            int[] coin=new int[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int i=1; i<=n; i++){
                coin[i]=Integer.parseInt(st.nextToken());
            }

            int m=Integer.parseInt(br.readLine());

            int[] dp=new int[m+1];

            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    if(j-coin[i]<0)
                    {

                    }
                    else if(j-coin[i]==0)
                    {
                        dp[j]=dp[j]+1;
                    }
                    else
                    {
                        dp[j]=dp[j]+dp[j-coin[i]];
                    }
                }
            }

            bw.append(dp[m]+"\n");



            

            t--;
        }

        bw.flush();
        bw.close();
        
    }
}

//10

//1, 2

//   1 2 3 4 5 6 7 8 9 10
// 1 1 1 1 1 1 1 1 1 1 1
// 2 1 2 3  0 1 0 1 0 1
