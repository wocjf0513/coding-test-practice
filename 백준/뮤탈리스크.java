import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뮤탈리스크 {

    static int damage[][]=new int[][]{{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
    static int dp[][][]=new int[61][61][61];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] scv=new int[4];
        for(int i=0; i<=60; i++){
            for(int j=0; j<=60; j++){
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i=1; i<=n; i++){
            scv[i]=Integer.parseInt(st.nextToken());
        }

        
        System.out.println(search(scv,0));
        
      

    }

    public static int search(int[] scv, int cnt){
       
        if(dp[scv[1]][scv[2]][scv[3]]!=Integer.MAX_VALUE){
            return dp[scv[1]][scv[2]][scv[3]];
        }

        boolean zeroCheck=true;

        for(int i=1; i<=3; i++){
            if(scv[i]!=0){
                zeroCheck=false;
            }
        }

        if(zeroCheck)
        return cnt;

        for(int i=0; i<6; i++){
            int temp[]=new int[4];
            temp[1]=scv[1]-damage[i][0];
            temp[2]=scv[2]-damage[i][1];
            temp[3]=scv[3]-damage[i][2];

            temp[1]=(temp[1]<=0)?0:temp[1];
            temp[2]=(temp[2]<=0)?0:temp[2];
            temp[3]=(temp[3]<=0)?0:temp[3];

            dp[scv[1]][scv[2]][scv[3]]=Math.min(dp[scv[1]][scv[2]][scv[3]],search(temp, cnt+1));
        }
        return dp[scv[1]][scv[2]][scv[3]];
    
    }
    
}
