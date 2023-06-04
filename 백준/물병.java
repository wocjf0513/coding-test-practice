import java.util.Scanner;

public class 물병 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong(); int k=sc.nextInt();
        
        long ans=0;
        int make=0;
        int rebase=0;
        int history=0;
        long remain=n;
        while(k>make){
            rebase++;
            if(remain<(long)Math.pow(2,rebase)){
                remain=remain-(long)Math.pow(2,rebase-1);
                make++;
                history=rebase-1;
                rebase=0;
            }

        }
        if(k==make && remain!=0 && remain+make>k){
            ans=(long)Math.pow(2,history)-remain;
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }


    }
    /**
     * Remain = n- 2의 제곱
     * 만든게 k와 같은 수면 (2의 제곱 - remain)을 산다. 
     * 아니면 Remain= n-2  */ 
}
