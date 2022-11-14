import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전5 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] dp=new int[k+1];
        for(int i=1; i<=n; i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp<=k)
            dp[temp]=1;
        }
        //있는 것들은 하나씩

        for(int i=1; i<=k; i++){
            if(dp[i]==0)
            dp[i]=100000;
            for(int j=1; j<=i/2; j++){
                dp[i]=Math.min(dp[i],dp[i-j]+dp[j]);
            }
            //아마 절반까지 해도 될듯...
            //5= 1 4 2 3  6= 1 5 2 4 3 3
        }
        // 1 5 12

        
        if(dp[k]==100000)
        bw.append("-1");
        else
        bw.append(Integer.toString(dp[k]));

        br.close();
        bw.close();

        
    }
    //동전의 개수가 최소가 되면서, 가치의 합이 k가 되는 
    //최소가 될때의 동전의 개수 
    
}
