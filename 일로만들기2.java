import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 일로만들기2 {

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        try{
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> dp[]=new ArrayList[n+1];
        dp[1]=new ArrayList<>();
        if(n>=2){
        dp[2]=new ArrayList<>(); dp[2].add(2);
        }
        if(n>=3){     
            dp[3]=new ArrayList<>(); dp[3].add(3);
        }
        for(int i=4; i<=n; i++){
            //3으로 나눠지는지
            //2로 나눠지는지
            dp[i]=new ArrayList<>();

            int where=3;
            //3 이면 하나 뺀걸로
            //2 이면 2로 나눈거
            //1 이면 3로 나눈거
            
            if(i%3==0){
                if(dp[i-1].size()>dp[i/3].size())
                where=1;
            }
            if(i%2==0){
                if(where==1){
                    if(dp[i/3].size()>dp[i/2].size())
                    where=2;
                }
                else{
                if(dp[i-1].size()>dp[i/2].size())
                where=2;
                }
            }
            switch(where){
                case 3:
                dp[i].addAll(dp[i-1]);
                break;
                case 2:
                dp[i].addAll(dp[i/2]);
                break;
                case 1:
                dp[i].addAll(dp[i/3]);
            }
            dp[i].add(i);
        }

        
        bw.append(dp[n].size()+"\n");
        for(int i=dp[n].size()-1; i>=0; i--){
            bw.append(dp[n].get(i)+" ");
        }
        
        
        bw.append(1+"");

        bw.flush();
        bw.close();
        br.close();
        }

        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //3으로 나누고
    //2로 나누고
    //1을 뺀다    
}
