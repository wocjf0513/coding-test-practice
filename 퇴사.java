import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사{

    static int[] max_pay;
    static int[][] pay;
    public static void main(String[] args) throws IOException {

        //4일
        //1일 일하고 4일
        //3일 일

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        max_pay=new int[n+2];
        pay=new int[n+2][2];
        for(int i=1; i<=n; i++){
            String[] s=br.readLine().split(" ");
            pay[i][0]=Integer.parseInt(s[0]);
            pay[i][1]=Integer.parseInt(s[1]);
        }
        //0번이 상담 일수 1번이 pay

        //j=0, 상담일수 2
        //4일차 

        
        for(int i=1; i<=n+1; i++){
            for(int j=1; j<i; j++){
                max_pay[i]=Math.max(max_pay[i],max_pay[j]); 
                if(pay[j][0]+j==i) 
                max_pay[i]=Math.max(max_pay[i],pay[j][1]+max_pay[j]);
            }
        }
        System.out.println(max_pay[n]);
    }
    
}
