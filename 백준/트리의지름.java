import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 트리의지름 {


    
 
    static class Node{
        LinkedList<Integer> childs=new LinkedList<>();
        int value=0;

        Node(int v){
            value=v;
        }
    }

    static Node[] tree;
    static int n;
    static long maxSum=0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        StringTokenizer st;

        tree=new Node[n+1];

        for(int i=0; i<=n; i++){
            tree[i]=new Node(0);
        }

   
        HashSet<Integer> roots=new HashSet<>();

        for(int i=1; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());

            tree[parent].childs.add(child);
            tree[child].value=value;

            roots.add(parent);
        }



        roots.stream().forEach(x->{
            HashMap<Integer,Integer> value=new HashMap<>();

            calTree(x,0,x, 0,value);

            
            long sum=0;
            List<Integer> list=value.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            for(int i=0; i<2&& i<list.size(); i++){
                sum+=list.get(i);
            }

            maxSum=Math.max(maxSum,sum);
            
        });


        System.out.println(maxSum);

        


        
        
    }
    public static void calTree(int startR, int cnt, int root, int sum, HashMap<Integer,Integer> vList){
        if(tree[root].childs.isEmpty()){
            if(vList.containsKey(startR)){
                if(vList.get(startR)<sum)
                {
                    vList.put(startR,sum);
                }
            }
            else{
                vList.put(startR,sum);
            }
            return;
        }

        for(int i=0; i<tree[root].childs.size(); i++){
            int childN=tree[root].childs.get(i);
            if(cnt==0)
            calTree(childN,cnt+1, childN, sum+tree[childN].value, vList);
            else
            calTree(startR,cnt+1, childN,sum+tree[childN].value, vList);
        }

       

    }
}
