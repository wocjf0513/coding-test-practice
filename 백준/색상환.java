import java.util.Scanner;

public class 색상환 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        long dp[][]=new long[n+1][k+1];

        //색상환 n개 중에 k개를 선택하는 경우 
       
        for(int i=1; i<=n; i++){
            dp[i][1]=i;
            dp[i][0]=1;
        }

        for(int i=3; i<=n; i++){
            for(int j=2; j<=k && j<=(i+1)/2; j++){
                dp[i][j]=(dp[i-2][j-1]+dp[i-1][j])%1000000003;
            }
        }

        System.out.println((dp[n-3][k-1]+dp[n-1][k])%1000000003);
    } 

    /**
     *  (1) Bit 마스킹
     * K에 따라 선택할 수 있는 경우를 bit로 표현
    이 전 bit에서 for문을 돌리며 bit가 안 켜져있으며, 양 옆 bit가 0이면 추가!
    => Bit 마스킹을 하는 숫자가 너무 커서 안된다
    **/

    /**
     * (2) i번째를 선택할 때, 
     * i-1과 0을 뺀 나머지 색 상환에서 k-1개 선택하기
     * 
     * i번째를 선택하지 않을 때,
     * i를 제외한 나머지 색 상환에서 k개 선택하기
     */
    
}
