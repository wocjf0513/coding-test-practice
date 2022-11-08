import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
    static int[][] R;
    static int[] kevin;

    public static void main(String[] args) throws IOException {
        //베이컨을 담을 수 있는 리스트와
        //관계를 담은 이중배열

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        kevin=new int[n+1];
        R=new int[n+1][n+1];
        int nR=Integer.parseInt(st.nextToken());

        for(int i=0; i<nR; i++){
            st=new StringTokenizer(br.readLine());
            R[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
        }

        for(int i=1; i<=n; i++){
            bfs(i);
        }
        int min=Integer.MAX_VALUE;
        int minPeople=0;

        for(int i=1; i<=n; i++){
            if(min>kevin[i]){
            min=kevin[i];
            minPeople=i;
            }
        }
        bw.write(Integer.toString(minPeople));
        bw.close();
        br.close();

        
        
    }
    public static void bfs(int x){
        Deque<int[]> que=new ArrayDeque<int[]>();
        que.add(new int[]{x,1});
        int len=R.length;
        int[] check=new int[len];
        
        while(!que.isEmpty()){
            int temp[]=que.poll();

            for(int i=1; i<len; i++){
                if(check[i]==0 && R[temp[0]][i]==1){
                    que.add(new int[]{i,temp[1]+1});
                    check[i]=temp[1];
                }
                if(check[i]==0 && R[i][temp[0]]==1){
                    que.add(new int[]{i,temp[1]+1});
                    check[i]=temp[1];
                }
            }
        }

        for(int i=1; i<=len-1; i++){
            if(i!=x){
                kevin[x]+=check[i];
            }
        }
    }
    
}
