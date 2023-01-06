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
            int count;
            Stuff(int w, int h, int c){
                weight=w;
                happy=h;
                count=c;
            }
        }

        ArrayList<Stuff> sList=new ArrayList<>();

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            sList.add(new Stuff(w, h, c ));
        }


        int[][] dp=new int[n+1][m+1];
        
        int[] pre=new int[m+1];

        for(int i=1; i<=n; i++){
            for(int c=0; c<sList.get(i-1).count; c++){
                if(c==0)
                for(int j=1; j<=m; j++){
                    if(j<sList.get(i-1).weight)
                    dp[i][j]=dp[i-1][j];
                    else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-sList.get(i-1).weight]+sList.get(i-1).happy);
                    }
                    pre[j]=dp[i][j];
                }
                else
                for(int j=1; j<=m; j++){
                    if(j<sList.get(i-1).weight)
                    dp[i][j]=pre[j];
                    else{
                        dp[i][j]=Math.max(pre[j],pre[j-sList.get(i-1).weight]+sList.get(i-1).happy);
                    }    
                }
                for(int j=1; j<=m; j++){
                    pre[j]=dp[i][j];  
                }
                
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=1; i<=m; i++){
            if(max<dp[n][i])
            max=dp[n][i];
        }
        System.out.println(max);

    }
    
}
