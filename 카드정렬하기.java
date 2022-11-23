import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 카드정렬하기 {


    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        PriorityQueue<Long> que=new PriorityQueue<>();

        long cards[]=new long[n+1];
        for(int i=0; i<n; i++)
        que.add(Long.parseLong(br.readLine()));


        
        long count=0;
        long sum=0;
        sum=que.poll();

        //min heap 필요


        while(!que.isEmpty()){
            sum+=que.poll();
            count+=sum;
            que.add(sum);
            if(!que.isEmpty())
            sum=que.poll();
        }
        System.out.println(count);
        //nlogn이 되어야한다.

    }
    //작은 묶음일수록 합치는데 덜 부담이 된다!!
    //합치는 시점 기준으로 가장 작은 묶음
}
