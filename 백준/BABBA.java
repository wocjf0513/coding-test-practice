import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());


        class AB{
            long a;
            long b;
            AB(long a, long b){
                this.a=a; this.b=b;
            }
        }
        
        AB dp[]=new AB[n+1];

        dp[0]=new AB(1,0);

        for(int i=1; i<=n; i++){
            dp[i]=new AB(dp[i-1].b,dp[i-1].a+dp[i-1].b);
        }

        System.out.println(dp[n].a+" "+dp[n].b);
        


    }
    
}

//A->B : 
//B->BA : 
