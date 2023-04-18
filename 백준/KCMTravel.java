import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KCMTravel {
    
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


    public static class Ticket implements Comparable<Ticket>{
        int toAirPortNum;
        int cost;
        int distance;

        Ticket(int t, int c, int d){
            toAirPortNum=t;
            cost=c;
            distance=d;
        }

        @Override
        public int compareTo(KCMTravel.Ticket o) {
            if(distance==o.distance){
                return cost-o.cost;
            }
            return distance-o.distance;
        }

    }


    public static void main(String[] args) throws IOException {
        int t=Integer.parseInt(br.readLine());

        while(t>0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken()); //공항 수
            int m=Integer.parseInt(st.nextToken()); //지원 비용
            int k=Integer.parseInt(st.nextToken()); //티켓 정보 수

            ArrayList<Ticket> graph[]=new ArrayList[n+1];

            for(int i=1; i<=n; i++){
                graph[i]=new ArrayList<Ticket>();
            }
            

            for(int i=1; i<=k; i++){
                st=new StringTokenizer(br.readLine());
                int v1=Integer.parseInt(st.nextToken());                
                int v2=Integer.parseInt(st.nextToken());                
                int cost=Integer.parseInt(st.nextToken());                
                int dist=Integer.parseInt(st.nextToken());    

                if(cost>m){
                    continue;
                }

                graph[v1].add(new Ticket(v2, cost, dist));
                
            }

            search(n,m, graph);

        
            t--;
        }
        bw.flush(); bw.close(); br.close();
    }
    public static void search(int nLimit, int mLimit, ArrayList<Ticket> graph[]) throws IOException{
        int dp[][]=new int[nLimit+1][mLimit+1];

        for(int i=1; i<=nLimit; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[1][0]=0;

        PriorityQueue<Ticket> pq=new PriorityQueue<>();

        pq.add(new Ticket(1,0,0));
        //curPort, curCost, curDist


        while(!pq.isEmpty()){
            Ticket temp=pq.poll();
            int curPort=temp.toAirPortNum;
            int curCost=temp.cost;
            int curDist=temp.distance;

            if(curPort==nLimit){
                dp[curPort][curCost]=Math.min(dp[curPort][curCost],curDist);
                break;
            }

            for(Ticket t: graph[curPort]){
                int nextPort=t.toAirPortNum;
                int nextCost=curCost+t.cost;
                int nextDist=curDist+t.distance;

                if(nextCost>mLimit){
                    continue;
                }

                
                if(nextDist>=dp[nextPort][nextCost]){
                    continue;
                }

                for(int i=nextCost; i<=mLimit; i++){
                    dp[nextPort][i]=Math.min(dp[nextPort][i],nextDist);
                }

                pq.add(new Ticket(nextPort, nextCost, nextDist));
            }

        }
        int min=Integer.MAX_VALUE;

        for(int i=1; i<=mLimit; i++){
            if(min>dp[nLimit][i])
            min=dp[nLimit][i];
        }
        if(min!=Integer.MAX_VALUE)
        bw.append(min+"\n");
        else
        bw.append("Poor KCM\n");
    }
    
}
