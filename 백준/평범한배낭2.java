import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.plaf.SliderUI;

public class 평범한배낭2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()); int m=Integer.parseInt(st.nextToken());
        


        class Stuff{
            int weight;
            int happy;
            Stuff(int w, int h){
                weight=w;
                happy=h;
            }
        }

        ArrayList<Stuff> sList=new ArrayList<>();
        sList.add(new Stuff(0, 0));

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

          

            int temp=1;
            int sum=0;
            //remain 3  2 0
            //c가 13 = 1 + 2 + 4 + 6

            // temp 1 2 4 8

            // sum 1 3 7 15

            // 13
            while(true){
                sum+=temp;
                if(sum>=c){
                    if(sum==c){
                        sList.add(new Stuff(w*temp, h*temp));
                        break;
                    }
                    else{
                        temp=c-(sum-temp);
                        sList.add(new Stuff(w*temp, h*temp));
                        break;
                    }
                }
                else{
                    sList.add(new Stuff(w*temp, h*temp));
                }
                temp=temp*2;
            }
        }


        int[][] dp=new int[sList.size()][10001];
        

        for(int i=1; i<sList.size(); i++){
                for(int j=1; j<=10000; j++){
                    if(j<sList.get(i).weight)
                    dp[i][j]=dp[i-1][j];
                    else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-sList.get(i).weight]+sList.get(i).happy);
                    }
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=1; i<=m; i++){
            if(max<dp[sList.size()-1][i])
            max=dp[sList.size()-1][i];
        }
        System.out.println(max);

    }
    
}
