import java.math.BigInteger;
import java.util.Scanner;

public class 이항계수3{

    static long p=1000000007;
    static int size=4000001;
    public static void main(String[] args) {
        //k는 n보다 작거나 같아야 한다.
        // 1
        //1 1


        Scanner sc=new Scanner(System.in);
        //1 2 

        int n=sc.nextInt();
        int k=sc.nextInt();
        
        long[] dp=new long[n+1];
    
        dp[0]=1;
        
        for(int i=1; i<=n; i++){
            if(i==1)
            dp[i]=1;
            else{
                dp[i]=(dp[i-1]*i)%p;
            }
        }

        //dp[k]*dp[n-k]의 역원을 구해야 된다. => 페르마의 소정리
        System.out.println((dp[n]*(pow((dp[k]*dp[n-k])%p,p-2)%p))%p) ;
    }
    public static long pow(long base, long expo){
        if(expo==1)
        return base%p;
        long temp=pow(base,expo/2);
        if(expo%2==1)
            return ((temp*temp)%p*base)%p;
        else
            return (temp*temp)%p;
    }
}