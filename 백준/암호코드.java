import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String code=br.readLine();
        char cur,pre;
        long[] dp=new long[5001];
        dp[0]=dp[1]=1;


        


        if(code.length()<=2){
            if(code.charAt(0)=='0'){
                System.out.println(0);
                return;
            }
        }

        for(int i=2; i<=code.length(); i++){
            cur=code.charAt(i-1);
            pre=code.charAt(i-2);
            if(cur=='0'){
                if(pre=='1' || pre=='2'){
                    dp[i]=dp[i-2]%1000000;
                }
                else{
                    break;
                }

            }
            else{
                if(pre=='0') 
                dp[i]=dp[i-1]%1000000;
				else {
					int temp=(pre-'0')*10+(cur-'0');
					if(1<=temp && temp<=26) 
                    dp[i]=(dp[i-2]+dp[i-1])%1000000;
					else dp[i]=dp[i-1]%1000000;
				}
            }
    }
    System.out.println(dp[code.length()]%1000000);
    //1글자와 2글자로 해석할수 있다.
    //1에서 26까지
    
}
}
