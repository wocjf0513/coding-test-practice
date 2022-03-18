import java.util.Scanner;

public class 제곱수의합 {

    public static int goal;
    public static int min=Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        goal=sc.nextInt();

        int dp[]=new int[goal+1];

        for(int i = 1; i <= goal; i++) {
			dp[i] = i;
		}

        for(int i=1; i<=goal; i++)
        {
            for(int j=1; j*j<=i; j++)
            {
                if(dp[i] > dp[i - (j * j)] + 1) {  
					dp[i] = dp[i - (j * j)] + 1;
				}
            }
        }
        System.out.println(dp[goal]);
        sc.close();
    }
    
}
