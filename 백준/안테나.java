import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 안테나 {

    // 첫째 줄에 집의 수 N이 자연수로 주어진다. (1≤N≤200,000) 둘째 줄에 N채의 집에 위치가 공백을 기준으로 구분되어 1이상 100,000이하의 자연수로 주어진다.

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int house[]=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        //입력

        PriorityQueue pq=new PriorityQueue<>();


      
        for(int i=1; i<=n; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
  
        for(int i=1; i<=(n-1)/2; i++){
            pq.poll();
        }

        System.out.println(pq.peek());
        
        // 1 5 7 9
    
        
        //알고리즘

        



    }
    
}
