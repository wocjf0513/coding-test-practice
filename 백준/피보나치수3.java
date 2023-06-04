import java.math.BigInteger;
import java.util.Scanner;

public class 피보나치수3 {

    final static int mod=1000000;
    final static int len=mod/10 *15;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger n=sc.nextBigInteger();

        int[] fibo=new int[len]; 

        for(int i=0; i<len; i++){
            if(i==0)
            fibo[i]=0;
            else if(i==1)
            fibo[i]=1;
            else{
                fibo[i]=(fibo[i-1]+fibo[i-2])%mod;
            }
        }
        System.out.println(fibo[n.mod(BigInteger.valueOf(len)).intValue()]);
        
    }
    
}
