import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 일학년 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] input=new int[n];
        long[][] dp=new long[n][21];
        int c=0;
        while(st.hasMoreTokens()){
            input[c]=Integer.parseInt(st.nextToken());
            c++;
        }


        for(int i=0; i<n-1; i++){
            if(i==0){
            dp[i][input[i]]++;
            }
            else{
                for(int j=0; j<=20; j++){
                    int plus=j+input[i];
                    int minus=j-input[i];
                    if(0<=plus && plus<=20){
                        dp[i][plus]+=dp[i-1][j];
                    }
                    if(0<=minus && minus<=20){
                        dp[i][minus]+=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][input[n-1]]);





    }

    //왼쪽부터 계산 0이상 20이하여야 한다.
    
    
}
