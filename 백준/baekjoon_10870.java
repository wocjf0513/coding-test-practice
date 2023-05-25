import java.util.Scanner;

public class baekjoon_10870 {

    public static void main(String[] args) {
     Scanner in=new Scanner(System.in);
     int input=in.nextInt();
     System.out.println(fibo(input));
    }
    public static int fibo(int n){

        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibo(n-1)+fibo(n-2);

    }
    
}
