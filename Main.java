import java.util.*;
public class Main {
	
	static long dp[][] ;
	static long dp_sum[];
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		dp = new long [1001][10]; 
		dp_sum=new long[1001];
		
		for(int i=0; i<10; i++){
			dp[1][i]=1;
			dp_sum[1]+=dp[1][i];
		}

		for(int j=2; j<=n; j++)
		{
			dp[j][0]=dp_sum[j-1];
			dp_sum[j]+=dp[j][0];
			for(int i=1; i<10; i++)
			{
				dp[j][i]=(dp[j][i-1]-dp[j-1][i-1]);
				dp_sum[j]+=dp[j][i];
			}
			dp_sum[j]=dp_sum[j];
		}
	System.out.println(dp_sum[n]%10007);
		
		
		
	}
	
}