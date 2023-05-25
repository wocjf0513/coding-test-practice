import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야 {

    public static void main(String[] args) throws IOException{
        //0층부터 0층 i호는 i명
        //아래층의 1호부터 원하는 호까지

        int[][]dp=new int[15][15];

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<15; i++){
            for(int j=0; j<15; j++){
                if(i==0)
                dp[i][j]=j;
                else{
                for(int k=1; k<=j; k++)
                dp[i][j]+=dp[i-1][k];
                }
            }
        }
        for(int i=0; i<n; i++){
            int f=Integer.parseInt(br.readLine());
            int r=Integer.parseInt(br.readLine());
            System.out.println(dp[f][r]);
        }
    }
    
}
