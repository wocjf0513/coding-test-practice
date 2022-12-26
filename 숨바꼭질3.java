import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질3 {

    static int time=Integer.MAX_VALUE;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        bfs(n,0);
        bw.append(time+""); bw.flush(); bw.close(); br.close();
       

    }
    public static void bfs(int x, int Ltime){
        Deque<int[]> dq=new LinkedList<>();
        int[] check=new int[100001];
        Arrays.fill(check, Integer.MAX_VALUE);
        check[x]=Ltime; 
        dq.add(new int[]{x,Ltime});

    
        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            int tempX=temp[0];
            int tempT=temp[1];
            if(tempX==k){
                if(time>tempT)
                time=tempT;
            }
            if(time<=tempT)
            continue;

            for(int i=1; i<=3; i++){
                if(i==3){
                    if(0<=tempX-1 && tempX-1<=100000 && check[tempX-1]>tempT)
                    {
                        check[tempX-1]=tempT+1;
                        dq.add(new int[]{tempX-1,tempT+1});
                    }
                    
                }
                if(i==2){
                    
                    if(k>tempX && 0<=tempX+1 && tempX+1<=100000 && check[tempX+1]>tempT)
                    {
                        check[tempX+1]=tempT+1;
                        dq.add(new int[]{tempX+1,tempT+1});
                    }
                    
                }
                if(i==1){
                    if(k>tempX && 0<=tempX*2 && tempX*2<=100000  && check[tempX*2]>tempT)
                    {
                        check[tempX*2]=tempT;
                        dq.add(new int[]{tempX*2,tempT});
                    }
                    
                }
            } 
            
        }
        
    }
    
}
