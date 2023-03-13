import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] sList=new String[4];
        for(int i=1; i<=3; i++){
            sList[i]=br.readLine();
        }

        int ans=calLCS(sList);

        System.out.println(ans);
    }
    public static int calLCS(String[] sList){
        int s1Len=sList[1].length();
        int s2Len=sList[2].length();
        int s3Len=sList[3].length();
        int dp[][][]=new int[s1Len+1][s2Len+1][s3Len+1];

        int max=0;


        for(int i=1; i<=s1Len; i++){
            for(int j=1; j<=s2Len; j++){
                for(int k=1; k<=s3Len; k++){
                    if(sList[1].charAt(i-1) == sList[2].charAt(j-1) && sList[2].charAt(j-1) == sList[3].charAt(k-1)){
                        dp[i][j][k]=Math.max(dp[i][j][k],dp[i-1][j-1][k-1]+1);
                    }
                    else{
                        dp[i][j][k]=Math.max(dp[i][j][k-1],Math.max(dp[i-1][j][k],dp[i][j-1][k]));
                    }
                    if(max<dp[i][j][k])
                    max=dp[i][j][k];


                }
            }
        }

        return max;


    }
    
}
