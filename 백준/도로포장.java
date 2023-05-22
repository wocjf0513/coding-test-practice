import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class 도로포장 {

    //1번에서 N번까지
    //양방향이고, 최소 거리
    //포장하면 거리가 0이된다.
    static int n,m,k;
    static int min=Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt(); m=sc.nextInt(); k=sc.nextInt();

        graph=new int[n+1][n+1];
        for(int i=1; i<=m; i++){
            int city1=sc.nextInt();
            int city2=sc.nextInt();
            int cost=sc.nextInt();
            graph[city1][city2]=cost;
            graph[city2][city1]=cost;
        }

        int[][] dp=new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dijkstra(1,k,0,dp);

        System.out.println(min);

        //k만큼만 포장했을 때, 최소 거리

    }
    //1부터 시작
    public static void dijkstra(int source,int remainK, int sumCost, int[][] dp){
        Deque<int[]> dq=new ArrayDeque<>();

       
        //dq에 저장해야 될거, 남은 k개수와 cost값, 가는 source
        dq.add(new int[]{source,remainK,sumCost});

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            int tempSource=temp[0];
            int tempK=temp[1];
            int tempCost=temp[2];

            if(tempSource==n){
                min=Math.min(tempCost,min);
                continue;
            }

            for(int i=1; i<=n; i++){
                if(graph[tempSource][i]!=0){
                    if(dp[i][tempK]>tempCost+graph[tempSource][i]){
                    dq.add(new int[]{i,tempK,tempCost+graph[tempSource][i]});
                    dp[i][tempK]=tempCost+graph[tempSource][i];
                    }
                    if(tempK>=1 && (dp[i][tempK-1]>tempCost)){
                    dq.add(new int[]{i,tempK-1,tempCost});
                    dp[i][tempK-1]=tempCost;
                    }
                }
            }
        }
    }
    
}
