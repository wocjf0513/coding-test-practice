import java.util.Scanner;

public class 한수 {

    public static void main(String[] args) {
        //각 자리의 숫자가 등차 수열
        //1보다 크거나 같고, N보다 작거나 같은

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int[] dp=new int[1001];
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1];
            if(is(i)) {
            dp[i]+=1;
            }
        }
        System.out.println(dp[n]);
    }
    public static boolean is(int n){
        if(n==1000){
            //1000
            return false;
        }
        else if(n>99){
            //100대
            int f=n/100;
            n=n-f*100;
            int s=n/10;
            n=n-s*10;
            int t=n/1;

            if(Math.abs(f-s)!=Math.abs(s-t) || (f+t)/2!=s)
            return false;
        }
        else{
            return true;
        }
        return true;
    }
    
}
