import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 내려가기 {
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        long maxScore=Integer.MIN_VALUE;
        long minScore=Integer.MAX_VALUE;

        int n=Integer.parseInt(br.readLine());

        long[] nList=new long[4]; //현재 입력 값
        long[][] dp=new long[4][2]; //최대 최소 값
        long[][] preDp=new long[4][2];
        //0은 이전 //1은 현재 
        
        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                nList[j]=Integer.parseInt(st.nextToken());
                if(i==1){
                    dp[j][0]=nList[j];
                    dp[j][1]=nList[j];
                }
                else{
                    long max=0;
                    long min=0;
                    if(j==1){
                        max=Math.max(preDp[j][0],preDp[j+1][0]);
                        min=Math.min(preDp[j][1],preDp[j+1][1]);
                        dp[j][0]=max+nList[j];
                        dp[j][1]=min+nList[j];
                    }
                    else if(j==3){
                        max=Math.max(preDp[j][0],preDp[j-1][0]);
                        min=Math.min(preDp[j][1],preDp[j-1][1]);
                        dp[j][0]=max+nList[j];
                        dp[j][1]=min+nList[j];
                    }
                    else{
                        max=Math.max(preDp[j][0],preDp[j+1][0]);
                        max=Math.max(max,preDp[j-1][0]);
                        min=Math.min(preDp[j][1],preDp[j+1][1]);
                        min=Math.min(min,preDp[j-1][1]);
                        dp[j][0]=max+nList[j];
                        dp[j][1]=min+nList[j];
                    }
                }
            }
            for(int j=1; j<=3; j++){
                preDp[j][0]=dp[j][0];
                preDp[j][1]=dp[j][1];
            }
            
        }

        for(int i=1; i<=3; i++)
        {
            if(maxScore<dp[i][0])
            maxScore=dp[i][0];
            if(minScore>dp[i][1])
            minScore=dp[i][1];
        }
        
        bw.write(maxScore+" "+minScore);
        bw.close();

        //n은 10만  => nlogn
        //점수 최대 점수 최소 점수

    }
}
    