import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 이분그래프 {

    static class Graph{
        boolean color;
        ArrayList<Integer> link=new ArrayList<>();
    }

    static Graph[] graph;
    static boolean isBipartiteGraph;
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int k=Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(k>0){
            isBipartiteGraph=true;

            st=new StringTokenizer(br.readLine());
            v=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());

            
            graph=new Graph[v+1];
            for(int i=1; i<=v; i++){
                graph[i]=new Graph();
            }

            for(int i=1; i<=e; i++){
                st=new StringTokenizer(br.readLine());
                int one=Integer.parseInt(st.nextToken());
                int two=Integer.parseInt(st.nextToken());
                graph[one].link.add(two);

                graph[two].link.add(one);
            }
            boolean vCheck[]=new boolean[v+1];
            
            if(paint(vCheck))
            bw.append("YES\n");
            else
            bw.append("NO\n");

            k--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean paint(boolean[] vCheck){
        
        Deque<Integer> dq=new LinkedList<>();

        for(int i=1; i<=v; i++){
            if(!vCheck[i]){
                dq.add(i);
                vCheck[i]=true;
                graph[i].color=true;
            }
            while(!dq.isEmpty()){
                int cur=dq.poll();

                for(int n:graph[cur].link){
                    if(!vCheck[n]){
                        dq.add(n);
                        vCheck[n]=true;
                        graph[n].color=!graph[cur].color;
                    }
                    else{
                        if(graph[n].color==graph[cur].color)
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //갔던 간선이 아닌 간선은 가도 돼 (갔던건 안 가게)
    //check 했던 건데 색깔이 다르면 false
}
