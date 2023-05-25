import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class 최단경로 {

    public static class Node{
        HashMap<Integer, Integer> hs;

        Node(){
            hs=new HashMap<>();
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());

        int start=Integer.parseInt(br.readLine());

        Node[] node=new Node[v+1];

        for(int i=1; i<=v; i++){
            node[i]=new Node();
        }

        for(int i=1; i<=e; i++){
            
        }

    }
}
