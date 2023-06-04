import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class 가장큰증가부분수열 {

    //dp[1]는 증가 부분 수열의 1을 포함했을 때 최대값
    //이중 for문 max값을 찾는다.

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] input=new int[n+1];
        int[] dp=new int[n+1];

        for(int i=1; i<=n; i++)
        {
            input[i]=sc.nextInt();
        }

        for(int i=1; i<=n; i++)
        {
            dp[i]=input[i];
            for(int j=1; j<i; j++)
            {
                if(input[j]<input[i])
                dp[i]=Math.max(dp[i],dp[j]+input[i]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        sc.close();
    }

}
