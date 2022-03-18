import java.math.BigInteger;
import java.util.*;
public class 오르막수 {
	
	static BigInteger dp[][] ;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		BigInteger dp_sum=new BigInteger("0");
		
		dp = new BigInteger [1001][11]; 

		for(int i=2; i<=n; i++){
			for(int j=1; j<=10; j++){
				dp[i][j]=new BigInteger("0");
			}
		}
		
		
		for(int i=1; i<=10; i++){
			dp[1][i]=new BigInteger("1");
		}


		for(int j=2; j<=n; j++)
		{
			for(int i=1; i<=10; i++)
			{
				for(int k=1; k<=i; k++)
				{
					dp[j][i]=dp[j][i].add(dp[j-1][k]);
				}
			}
		}

		for(int i=1; i<=10; i++)
		dp_sum=dp_sum.add(dp[n][i]);

		System.out.println(dp_sum.remainder(new BigInteger("10007")));
		sc.close();
		
		
		
	}
             //change context
}
