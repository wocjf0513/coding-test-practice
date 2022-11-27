import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] list=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        ArrayList<Integer>[] nList=new ArrayList[n+1];

        for(int i=1; i<=n; i++){
        list[i]=Integer.parseInt(st.nextToken());
        nList[i]=new ArrayList<>();
        }
        int[] dp=new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i]=1;
            nList[i].add(list[i]);
            for(int j=1; j<i; j++){
                if(list[j]<list[i]){
                    if(dp[i]<1+dp[j]){
                        nList[i].clear();
                        nList[i].addAll(nList[j]);
                        nList[i].add(list[i]);
                        dp[i]=1+dp[j];
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int idx=0;

        for(int i=1; i<=n; i++){
            if(max<dp[i]){
            max=dp[i];
            idx=i;
            }
        }
        System.out.println(max);
        Collections.sort(nList[idx]);
        for(int i:nList[idx]){
            System.out.print(i+" ");
        }
        
        
    }
    //N<=1000
    
}
