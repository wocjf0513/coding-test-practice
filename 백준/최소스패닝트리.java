import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 최소스패닝트리 {

    static long minV=Long.MAX_VALUE;

    public static class Node{
        HashMap<Integer,Integer> edge;

        Node(){
            edge=new HashMap<>();
        }
    }



    public static void main(String[] args) throws IOException{
        //정점 간선 개수

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());

        Node[] nodes=new Node[n+1];

        for(int i=1; i<=n; i++){
            nodes[i]=new Node();
        }


        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken()); 
            int v2=Integer.parseInt(st.nextToken()); 
            int val=Integer.parseInt(st.nextToken());

            nodes[v1].edge.put(v2, val);
            nodes[v2].edge.put(v1, val);
        }

        search(nodes, 1, new boolean[n], 0);
        System.out.println(minV);
    }
    public static void search(Node[] nodes,int idx, boolean[] check, long sum){

        boolean isEnd=true;

        check[idx-1]=true;

        for(boolean b:check){
            if(b){

            }
            else{
                isEnd=false;
            }
        }

        if(isEnd)
        {
            if(minV>sum){
                minV=sum;
                return;
            }
        }
        HashMap<Integer,Integer> nodeE=nodes[idx].edge;

        

        for(int n:nodeE.keySet()){
            if(!check[n-1]){
                search(nodes, n, check, sum+=nodeE.get(n));
            }
        }
    }
    
}
