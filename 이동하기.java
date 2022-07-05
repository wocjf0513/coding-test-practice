import java.util.Scanner;

public class 이동하기 {

    //이전 경로중 가장 큰걸 더한다.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y=sc.nextInt();
        int x=sc.nextInt();

        int input[][]=new int[y][x];
        int dp[][]=new int[y][x];
        for(int i=0; i<y; i++)
        {
            for(int j=0; j<x; j++)
            {
                input[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<y; i++)
        {
            for(int j=0; j<x; j++)
            {
                dp[i][j]=input[i][j];
                int one=0,two=0,three=0;
                if(i-1>=0)
                {
                    one=dp[i-1][j];
                }
                if(j-1>=0)
                {
                    two=dp[i][j-1];
                }
                if(i-1>=0 && j-1>=0)
                {
                    three=dp[i-1][j-1];
                }
                dp[i][j]+=Math.max(Math.max(one,two),three);
            
            }
        }
        System.out.println(dp[y-1][x-1]);
        

        sc.close();
        
    }
    
}
