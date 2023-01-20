import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579{

    public static void main(String[] args) throws IOException{
    
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int[] input=new int[n+1];
        int[] stairs=new int[n+1];
        for(int i=1; i<=n; i++){
            input[i]=Integer.parseInt(bf.readLine());
        }
        
        for(int i=1; i<=n; i++){
            if(i==1){
                stairs[i]=input[i]; //1
                continue;
            }
            if(i==2){
                stairs[2]=input[2]+input[1]; //3
                continue;
            }
            if(i==3){
                stairs[3]=Math.max(input[3]+input[2],input[3]+input[1]);
                continue;
            }
            stairs[i]=Math.max(input[i]+input[i-1]+stairs[i-3],input[i]+stairs[i-2]);
        }

        System.out.println(stairs[n]);
    }
}