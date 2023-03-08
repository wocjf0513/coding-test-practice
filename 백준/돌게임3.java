import java.util.Scanner;

public class 돌게임3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //게임은 상근이가 먼저

        boolean dp[]=new boolean[n+1];

        //상대 턴에 두 개가 남으면 이긴다.

        //1
        //1 1
        //3 1 1
        //4 1 1
        for(int i=1; i<=n; i++){
            if(i<=4){
                if(i==1 || i==3 || i==4)
                dp[i]=true;
                else
                dp[i]=false;
            }
            else{
                if(dp[i-4] && dp[i-3] && dp[i-1]){
                    dp[i]=false;
                }   
                else{
                    dp[i]=true;
                }
            }
        }

        //완벽한 게임을 위해서 전 차례에 전부 상근이가 이겼으면
        //이번 차례에 찬영이가 이기고
        //한번이라도 찬영이가 이겼다면, 상근이가 이번에 이긴다.

        if(dp[n])
        System.out.println("SK");
        else
        System.out.println("CY");
    }
    
}
