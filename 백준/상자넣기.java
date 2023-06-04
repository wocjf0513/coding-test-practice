import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 상자넣기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());

        int len=n;
        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] nList=new int[n];
        while(n>0){
            nList[len-n]=Integer.parseInt(st.nextToken());
            n--;
        }

        int dp[]=new int[len];

        int max=0;

        for(int i=0; i<len; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(nList[j]<nList[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
                
            }
            if(max<dp[i])
            max=dp[i];
        }

        bw.append(max+"");
        bw.flush();
        bw.close();



    }
    //최대 넣을 수 있는 상자의 개수 
    
}
