import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 카드게임 {

    static int dp[][][];
    static int cards[];
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        while(t>0){
            n=Integer.parseInt(br.readLine());
            cards=new int[n];

            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                cards[i]=Integer.parseInt(st.nextToken());
            }

            dp=new int[2][n][n];
            //알고리즘필요 


            bw.append(dfs(0,n-1,0)+"\n");

            t--;
        }
        bw.flush();bw.close();br.close();
    }
    public static int dfs(int start, int end, int turn){
        if(start>end){
            return 0;
        }
        if(dp[turn][start][end]!=0)
        return dp[turn][start][end];
        
        else{
            if(turn==0){
                return dp[turn][start][end]=Math.max(dfs(start+1,end,1)+cards[start],dfs(start,end-1,1)+cards[end]);
            }
            else{
                return dp[turn][start][end]=Math.min(dfs(start+1,end,0),dfs(start,end-1,0));
            }
        }
    }
    
}
