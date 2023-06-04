import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class 타일링 {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger[] dp=new BigInteger[251];
        dp[0]=BigInteger.ONE;
        dp[1]=BigInteger.ONE;
        dp[2]=BigInteger.valueOf(3);

        for(int i=3; i<=250; i++){
            dp[i]=dp[i-2].multiply(BigInteger.TWO).add(dp[i-1]);
        }
        String line="";
        while((line=br.readLine())!=null){
            int n=Integer.parseInt(line);
            //알고리즘
            bw.append(dp[n]+"\n");

            //dp[n]=dp[n-2]*2+ dp[n-1] 
            //dp[n-2] 를2*2타일로 채우고, 2*1을 가로로 놓은 두개로 채우는 방식과
            //dp[n-1]를 2*1세로로 넣은 방식!! 이 있다.    
        }
        bw.flush(); bw.close(); br.close();
    }
    
}
