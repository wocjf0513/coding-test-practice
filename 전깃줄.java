import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 전깃줄{
    //교차하지 않기 위해선 평행해야 된다.
    //설치 가능 최대 개수

    static int list[]=new int[501];
    static int dp[]=new int[501];
    static int max=0;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int a,b;
     
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            list[a]=b;
            dp[a]=1;
        }
        for(int i=1;i<501;i++){
            if(dp[i]!=0){
            for(int j=0; j<i; j++){
                if(dp[j]!=0 && list[j]<list[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                    }
                }
            }
        }
        System.out.println(n-max);
 
    }
}