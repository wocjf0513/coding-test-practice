import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합2 {

    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] nList=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            nList[i]=Integer.parseInt(st.nextToken());
        }

        //sum[i] : i까지 합

        int dpNoRemove=0;
        int dpRemove=0; 

        

        for(int i=1; i<=n; i++){
            if(dpNoRemove==0)
            dpRemove=dpRemove+nList[i];
            else
            dpRemove=Math.max(dpNoRemove,dpRemove+nList[i]);
            dpNoRemove=Math.max(dpNoRemove+nList[i],nList[i]);
          
            max=Math.max(max,dpNoRemove);
            max=Math.max(max,dpRemove);
        }
        // dp[i][j][0]+dp[j+1][k] i부터 k까지 j를 제거했을 때

        System.out.println(max);
     
        
      

    }
}
