import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class 파일합치기3{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        while(t>0){
            int n=Integer.parseInt(br.readLine());
            long[] nList=new long[n+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                nList[i]=Long.parseLong(st.nextToken());
            }
            sb.append(calCost(nList)+"\n");
            t--;
        }
        System.out.println(sb.toString());


    }
    public static long calCost(long[] nList){
        long cost=0;
        PriorityQueue<Long> que=new PriorityQueue<>();

        for(long i:nList)
        que.add(i);

        que.poll();

        while(que.size()>1){
            long f=que.poll();
            long s=que.poll();
            cost+=f+s;
            que.add(f+s);
        }


        return cost;
    }
}