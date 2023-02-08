import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 이분그래프 {

    static class Graph{
        int color;
        ArrayList<Integer> link=new ArrayList<>();
    }

    static Graph[] graph;
    static boolean isBinaryGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(k>0){
            isBinaryGraph=true;

            st=new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
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

            paint(1,1);

            if(isBinaryGraph)
            System.out.println("YES");
            else
            System.out.println("NO");

            k--;
        }
    }
    public static void paint(int num, int color){

        if(!isBinaryGraph)
        return;


        if(graph[num].color!=0)
        {
            if(graph[num].color!=color){
            isBinaryGraph=false;
            }
            return;
        }

        graph[num].color=color;

    
        for(int n:graph[num].link){
            paint(n,(color+1)%2);
        }
    }
    
}
