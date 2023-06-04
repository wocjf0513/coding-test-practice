import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사2{

    static class Counseal{
        int day;
        int price;

        Counseal(int d, int p){
            day=d;
            price=p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        Counseal[] cList=new Counseal[n+1];


        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            cList[i]=new Counseal(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int[] dp=new int[n+2];

        for(int i=n; i>=1; i--){
            dp[i]=dp[i+1];
            if(i+cList[i].day<=n+1){
                dp[i]=Math.max(cList[i].price+dp[i+cList[i].day],dp[i]);
            }
        }
        System.out.println(dp[1]);



    }
}