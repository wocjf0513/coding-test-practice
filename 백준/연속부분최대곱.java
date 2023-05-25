import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class 연속부분최대곱 {


    public static void main(String[] args ) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        double[] inputList=new double[n+1];

        for(int i=1; i<=n; i++){
            inputList[i]=Double.parseDouble(br.readLine());
        }

        double[] dp=new double[n+1];

        for(int i=1; i<=n; i++){
            dp[i]=inputList[i];
            double comp=inputList[i];
            for(int j=i+1; j<=n; j++){
                comp*=inputList[j];
                dp[i]=Math.max(dp[i],comp);
            }
    
        }

        System.out.println(String.format("%.3f", Arrays.stream(dp).max().getAsDouble()));

    }
    
}
