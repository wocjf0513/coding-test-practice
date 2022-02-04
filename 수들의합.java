
import java.io.IOException;
import java.util.Scanner;

public class 수들의합 {

    public static void main(String[] args) throws IOException {
        
            Scanner sc=new Scanner(System.in);
            long n=sc.nextLong();

        long sum=0,count=0,temp=1;


        while(true){
            sum+=temp;
            if(n>=sum){
            temp++;
            count++;
            }
            else
            break;
        }
        System.out.println(count);

        sc.close();
    }

    
}
