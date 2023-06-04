import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 회사문화1 {
    
    static int n,m;
    static ArrayList<Integer>[] juniors;
    static long[] dp;

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); int m=Integer.parseInt(st.nextToken());
        juniors=new ArrayList[n+1];

        dp=new long[n+1]; //사원은 1부터 시작하며, 1은 boss이다. 

        st=new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            juniors[i]=new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            //직원의 상사 정보
            
            int senior=Integer.parseInt(st.nextToken());
            if(senior==-1){
                continue;
            }
            else{

                juniors[senior].add(i); //직속 후배 정보가 들어있다. 직속 후배가 여러명일경우.... 생각안했다.
            }
        }

        for(int i=1; i<=m; i++){
            //칭찬 받은 사원 과 칭찬의 정보가 입력으로 들어온다.
            st=new StringTokenizer(br.readLine());
            int bePraise=Integer.parseInt(st.nextToken());
            int praiseDegree=Integer.parseInt(st.nextToken());

            dp[bePraise]+=praiseDegree;

            //타고가면서 +해야된다. 근데, 최악의 경우 100,000 * 100.000이 되니 제한 초를 넘게 된다. 
            //for문을 나눠서 하면 된다.
        }
        //입력 받은 정보를 통해 상사부터 내리 칭찬 시물레이션 구현

        search(0,1);

        for(int i=1; i<=n; i++){
            bw.append(dp[i]+" ");
        }
        bw.flush(); 

    

    }
    public static void search(int pre, int cur) throws IOException{

        dp[cur]+=dp[pre];
        
        if(juniors[cur].size()==0){
            return;
        }
        else{
            for(int junior:juniors[cur]){
                search(cur, junior);
            }
        }

    }
}
