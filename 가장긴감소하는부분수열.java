import java.util.Arrays;
import java.util.Scanner;

public class 가장긴감소하는부분수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int input[]=new int[n+1];
        int dp[]=new int[n+1];
        for(int i=1; i<=n; i++)
        {
            input[i]=sc.nextInt();
        }

    
        for(int i=1; i<=n; i++)
        {
            dp[i]=1;
        for(int j=1; j<i; j++)
        {
            if(input[i]<input[j])
            dp[i]=Math.max(dp[i],dp[j]+1);
        }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
        sc.close();


    }
    
}
