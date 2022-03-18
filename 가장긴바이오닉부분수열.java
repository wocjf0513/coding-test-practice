import java.io.IOException;
import java.util.Scanner;

public class 가장긴바이오닉부분수열 {

    //LIS
    //LDS
    //하나는 반대로 해서 MAX값을 구한다.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[] input = new int[n]; 
        int[] dp_i = new int[n];
        int[] dp_d = new int[n];
        for (int i = 0; i < input.length; i++) { 
            input[i] = sc.nextInt(); 
        }



        for(int i=0; i<input.length; i++){
            dp_i[i]=1;
            for(int j=0; j<i; j++){
                if(input[j]<input[i])
                dp_i[i]=Math.max(dp_i[i],dp_i[j]+1);
            }
        }
        
    
        for(int i=input.length-1; 0<=i; i--){
            dp_d[i]=1;
            for(int j=input.length-1; i<j; j--){
                if(input[j]<input[i])
                dp_d[i]=Math.max(dp_d[i],dp_d[j]+1);
            }
        }

        int max=0;
        for(int i=0; i<input.length; i++){
            max=Math.max(max,dp_d[i]+dp_i[i]-1);
        }

        System.out.println(max);
        sc.close();

        
    }
    
}
