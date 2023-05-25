import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 무한수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int p=sc.nextInt();
        int q=sc.nextInt();

        HashMap<Long,Integer> dp=new HashMap<>();

        dp.put(Long.valueOf(0),1);

        for(long i=1; i<=n; i++){
            dp.put(i,dp.get(i/p)+dp.get(i/q));
        }

        System.out.println(dp.get(n));



    }
    
}
