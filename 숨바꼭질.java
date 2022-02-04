import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 숨바꼭질 {

    static int[] visit=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int K=Integer.parseInt(str[1]);

        bfs(N,K);

    }
    public static Boolean valid(int N){
        if(0<=N && N<=100000 && visit[N]!=1)
        return true;

        return false;
    }
    public static void bfs(int N,int K){

        Deque<int[]> deque=new LinkedList<>();

        deque.add(new int[]{N,0});
        visit[N]=1;

        while(!deque.isEmpty()){
            int[] temp=deque.poll();
            int n=temp[0];
            int count=temp[1];

            if(n==K){
                System.out.println(count);
                return;
            }

            if(valid(n+1)){
                visit[n+1]=1;
                deque.add(new int[]{n+1,count+1});
            }
            if(valid(n-1)){
                visit[n-1]=1;
                deque.add(new int[]{n-1,count+1});
            }
            if(valid(n*2)){
                visit[n*2]=1;
                deque.add(new int[]{n*2,count+1});
            }

        }
        
        

    }
    
}
