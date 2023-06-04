import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 장난감조립 {

    static int dp[][];
    static int basic[];
    static int n;
        public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        dp=new int[n+1][n+1];
        basic=new int[n+1];

        while(m>0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            dp[x][y]=k;
            basic[x]=-1;

            //x를 만드는데, y부품, k개가 필요하다.
            //입력을 받고 -> for문을 돌리면서 기본 부품으로만 만들 수 있게 변경!

            m--;
        }

        /*
        i번째를 만들기 위해 , 만들기 위한 기본 부품, 중간 부품들이 있을테니
        그걸 확인하면서 
        */

        make(n,1);

        for(int i=1; i<=n; i++){
            if(basic[i]!=-1)
            {
                bw.append(i+" "+basic[i]+"\n");
            }
        }
        bw.flush();
    }
    public static void make(int idx, int k){
        if(n==15)
        System.out.println("hello");
        if(basic[idx]!=-1){
            basic[idx]+=k;
        }
        else{
            for(int i=1; i<n; i++){
                if(dp[idx][i]>0){
                    make(i,dp[idx][i]*k);
                }
            }
        }
        return;
    }


    
}
