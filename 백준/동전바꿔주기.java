import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전바꿔주기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());

        StringTokenizer st;

        int dp[][]=new int[k+1][t+1];

        //t는 금액, k는 가지 수


        for(int i=1; i<=k; i++){
            st=new StringTokenizer(br.readLine());
            
            int cost=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());

            if(i==1){
                for(int j=1; j<=num; j++){
                    if(cost*j>t)
                    break;
                    dp[i][cost*j]=1;
                }
            }
            else{
                for(int j=1; j<=num; j++){
                    if(cost*j>t)
                    break;
                    dp[i][cost*j]=1;
                }

                for(int j=0; j<=num; j++){
                    for(int z=1; z<=t; z++){
                        if(cost*j+z>t)
                        break;

                        dp[i][cost*j+z]+=dp[i-1][z];
                    }
                }
            }

        }

        System.out.println(dp[k][t]);

    }
    
}
