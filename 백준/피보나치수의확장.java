import java.util.Scanner;

public class 피보나치수의확장 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        long ans=0;

        if(n<0){
            n=-1*n;
            long dp[]=new long[n+1];
           

            dp[0]=0;
            dp[1]=1;

            for(int i=2; i<=n; i++){
                dp[i]=(dp[i-2]-dp[i-1])%1000000000;
            } 

            ans=dp[n];

        }
        else if(n>0){
            long dp[]=new long[n+1];
            dp[0]=0;
            dp[1]=1;

            for(int i=2; i<=n; i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000000;
            }

            ans=dp[n];

        }
        else{
            ans=0;
        }


        if(ans<0){
            System.out.println(-1+"\n"+Math.abs(ans));
        }
        else if(ans==0){
            System.out.println(0+"\n"+ans);
        }
        else{
            System.out.println(1+"\n"+ans);
        }
    }
    /**
     * 1,000,000,000으로 나눈 나머지
     */
    
}
