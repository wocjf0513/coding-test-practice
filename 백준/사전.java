import java.math.BigInteger;
import java.util.Scanner;

public class 사전 {

    static BigInteger[][] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        BigInteger k=sc.nextBigInteger();

       dp=new BigInteger[n+1][m+1]; 
       for(int i=1; i<=n; i++){
            dp[i][0]=BigInteger.ONE;
       }
        for(int i=1; i<=m; i++){
            dp[0][i]=BigInteger.ONE;
        }
       // dp[n][m]= dp[n-1][m]+ dp[n][m-1];
       // a 가 n개 z가 m개일때 문자열 개수

       for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j]=(dp[i-1][j].add(dp[i][j-1]));
            }
       }

       if(dp[n][m].compareTo(k)<0){
        System.out.println(-1);
       }
       else{
        System.out.println(make(n,m,k));
       }

    }

    public static String make(int n, int m, BigInteger k){
        StringBuilder sb=new StringBuilder();

        while(!(n==0 || m==0)){
            if(dp[n-1][m].compareTo(k)<0) //맨 앞이 z인 경우
            {
                sb.append("z");
                k=k.subtract(dp[n-1][m]);
                m-=1;
            }
            else{             //맨 앞이 z인 경우
                sb.append("a");
                n-=1;
            }
        }
        if(n>0){
            for(int i=0; i<n; i++){
                sb.append("a");
            }
            return sb.toString();
        }
        else if(m>0){
            for(int i=0; i<m; i++){
                sb.append("z");
            }
            return sb.toString();
        }
        else{
            return sb.toString();
        }
    }
    
}

/*       z
 *   1 1 1
 *   1 2 3
 * a 1 3 6
 */

