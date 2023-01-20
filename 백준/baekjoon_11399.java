import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class baekjoon_11399 {

    //정렬만 하면 문제를 풀 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,n=Integer.parseInt(br.readLine());

        int data[]=new int[n];
        int cost[]=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(i=0; i<n; i++)
        data[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(data);

        cost[0]=data[0];

        int sum_cost=cost[0];

        for(i=1; i<n; i++){
        cost[i]=cost[i-1]+data[i];
        sum_cost+=cost[i];
        }

        System.out.println(sum_cost);


        
    }
    
}
