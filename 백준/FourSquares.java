import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FourSquares {

    public static void main(String[] args) {
        //최소 nlng(n)
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int n=Integer.parseInt(br.readLine());
            int[] dp=new int[n+1];
            ArrayList<Integer> pq=new ArrayList<>();

            for(int i=1; i<=n; i++){
                if(Math.sqrt(i)%1==0){
                    dp[i]=1;
                    pq.add(i);
                }
                else{
                    dp[i]=Integer.MAX_VALUE;
                    for(int j=0; j<pq.size(); j++){
                        dp[i]=Math.min(dp[i],dp[i-pq.get(j)]+dp[pq.get(j)]);

                    }

                }

            }
            //1 1
            //2 1 1
            //3 1 1 1
            //4 4
            //5 4 1
            //6 4 
            bw.append(dp[n]+"");
            bw.flush();
            bw.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
