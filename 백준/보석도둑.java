import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑 {


    static class Gem{
        int weight;
        int cost;

        Gem(int w, int c){
            weight=w;
            cost=c;
        }
    }


    //O(nlog(n))


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        Gem[] gemList=new Gem[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            gemList[i]=new Gem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(gemList,new Comparator<Gem>() {
            //return 값이 1이면 바꿈
            @Override
            public int compare(Gem o1, Gem o2) {
                if(o1.weight==o2.weight){
                return o2.cost-o1.cost;
                }
                return o1.weight-o2.weight;
            }
        });

        int[] bagList=new int[k];
    
        for(int i=0; i<k; i++){
            bagList[i]=Integer.parseInt(br.readLine());
        }


        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());


        long sumCost=0;

        for(int i=0,j=0; i<k; i++){
            //j는 보석 index

            while(j<n && gemList[j].weight<=bagList[i]){
                pq.offer(gemList[j++].cost);
            }

            if(!pq.isEmpty()){
            sumCost+=pq.poll();
            }

        }


        System.out.println(sumCost);
        br.close();
        
    }
  
}

