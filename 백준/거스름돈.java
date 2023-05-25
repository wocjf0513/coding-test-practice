import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.RMIClassLoader;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int remain=Integer.parseInt(br.readLine());
        int fiveN=0;
        int twoN=0;


        if(remain==1 || remain==3){
        System.out.println(-1);
        return;
        }

        //홀수면
        if((remain%5)%2==1){
            fiveN=remain/5;
            fiveN=fiveN-1;
            remain=remain-fiveN*5;
            twoN=remain/2;
        }
        else{
            fiveN=remain/5;
            remain=remain%5;
            twoN=remain/2;
        }
        System.out.println(fiveN+twoN);
    }
}
