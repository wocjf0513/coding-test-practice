import java.util.Scanner;

public class 돌게임4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        boolean dp[]=new boolean[n+1];

        dp[1]=true; //CY승
        
        for(int i=2; i<=n; i++){
            dp[i]=true;

            if(i-4>=1 && dp[i-4]){
                dp[i]=false;
            }
            else if(i-3>=1 && dp[i-3]){
                dp[i]=false;
            }
            else if(i-1>=1 && dp[i-1]){
                dp[i]=false;
            }
        }

        if(dp[n]){
            System.out.println("CY");
        }
        else{

            System.out.println("SK");
        }

        
    }
    
}
