import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 첫째 줄에는 아이들의 수 N이 주어진다. 둘째 줄부터는 1부터 N까지의 숫자가 한 줄에 하나씩 주어진다. N은 2 이상 200 이하의 정수이다.
// 1초


public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());


        //입력

        int[] input=new int[n+1];
        for(int i=1; i<=n; i++){
            input[i]=Integer.parseInt(br.readLine());
        }

        //LIS 알고리즘

        int[] dp=new int[n+1];


        for(int i=1; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(input[i]>input[j])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }

        int ans=n-Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);



    }    
}
