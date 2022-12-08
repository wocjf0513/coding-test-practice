import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 이분그래프 {

    static boolean check=true;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t>0){
            check=true;
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int inform=Integer.parseInt(st.nextToken());
            ArrayList<Integer> graph[]=new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i]=new ArrayList<>();
            }
            int v1=0,v2=0;
            while(inform>0){
                st=new StringTokenizer(br.readLine());
                v1=Integer.parseInt(st.nextToken());
                v2=Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                graph[v2].add(v1);
                inform--;
            }
            bfs(graph,v1);
            //markcolor 2 3 
            if(check)
            {
                bw.append("YES\n");
            }
            else{
            bw.append("NO\n");
            }
            t--;
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static void bfs( ArrayList<Integer> graph[],int source){
        Deque<Integer> que=new LinkedList<>();
        int[] mark=new int[graph.length];
        que.add(source);
        while(!que.isEmpty()){
            int temp=que.poll();
            for(int i=0; i<graph[temp].size(); i++){
                if(mark[graph[temp].get(i)]==0){
                    mark[graph[temp].get(i)]==1;
                }
                else if(graph[temp[0]][i]==1){
                    graph[temp[0]][i]=temp[1];
                    if(temp[1]==2)
                    que.add(new int[]{i,3});
                    if(temp[1]==3)
                    que.add(new int[]{i,2});
                }
                else{
                    if(graph[temp[0]][i]!=temp[1]){
                        check=false;
                        return;
                    }
                    else{
                    }
                }
            }
        }
        
        

    }
    
}
/*
그래프의 정점의 집합을 둘로 분할하여,
각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 
이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
 */

 /*
  * 모든 꼭짓점을 빨강과 파랑으로 색칠하되,
   모든 변이 빨강과 파랑 꼭짓점을 포함하도록 색칠할 수 있는 그래프
  */