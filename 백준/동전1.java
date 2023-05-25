import java.util.Scanner;

class 동전1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int goal=sc.nextInt();

        int input[]=new int[n+1];
        for(int i=1; i<=n; i++)
        input[i]=sc.nextInt();

        int dp[]=new int[goal+1];

        dp[0]=1;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=goal; j++)
            {
                if(input[i]<=j)
                dp[j]+=dp[j-input[i]];
            }            
        }

        System.out.println(dp[goal]);

        sc.close();


    }
}