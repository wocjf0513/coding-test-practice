import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static List<Integer> vList[];
    static int[] parents;
    static int n;

    public static void main(String[] args) throws IOException{
        //해당 정보로 트리를 구성
        //1부터 시작해서 bfs탐색 -> list에 각 노드에 부모를 저장

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        vList=new ArrayList[n+1];
        for(int i=1; i<=n; i++)
        vList[i]=new ArrayList<Integer>();
        //메모리 할당을 바꿔야 한다..

        parents=new int[n+1];

        for(int i=1; i<n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken()); 
            int v2=Integer.parseInt(st.nextToken());
            vList[v1].add(v2);
            vList[v2].add(v1);
        }
        
        bfs(1);

        for(int i=2; i<=n; i++)
        System.out.println(parents[i]);
        
    }
    public static void bfs(int x){
        Deque<Integer> deque=new LinkedList<>();

        deque.add(x);
        while(!deque.isEmpty()){
            int temp=deque.poll();
            for(Integer i: vList[temp]){
                if((parents[i]==0)){
                    deque.add(i);
                    parents[i]=temp;
                }
            }
        }

    }
    
}
