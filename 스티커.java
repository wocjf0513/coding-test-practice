import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 스티커 {

    static int num;
    static int[][] num_arr;
    static int[][] dp_arr;

    //각 단계에 나올 수 있는 경우의 수는 각 전단계의 다른 row, 전전단계의 다른 row에 영향을 갖는다.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            num=Integer.parseInt(br.readLine());
            num_arr=new int[2][num];
            dp_arr=new int[2][num];
            String s[]=br.readLine().split(" ");
            for(int j=0; j<num; j++)
            num_arr[0][j]=Integer.parseInt(s[j]);
            s=br.readLine().split(" ");
            for(int j=0; j<num; j++)
            num_arr[1][j]=Integer.parseInt(s[j]);

            System.out.println(max_score(num,num_arr,dp_arr));

        }

    
        
    }
    public static int max_score(int num, int[][] num_arr, int[][] dp_arr){

        if(num>=1)
        {

            dp_arr[0][0]=num_arr[0][0];
            dp_arr[1][0]=num_arr[1][0];
            if(num>=2)
            {
                dp_arr[0][1]=dp_arr[1][0]+num_arr[0][1];
                dp_arr[1][1]=dp_arr[0][0]+num_arr[1][1];

                for(int i=2; i<num; i++)
                {
                    dp_arr[0][i]=Math.max(dp_arr[1][i-1],dp_arr[1][i-2])+num_arr[0][i];
                    dp_arr[1][i]=Math.max(dp_arr[0][i-1],dp_arr[0][i-2])+num_arr[1][i];
                }
            }
            return Math.max(dp_arr[0][num-1],dp_arr[1][num-1]);
        }
        else
        {
            return 0;
        }


    }
}
