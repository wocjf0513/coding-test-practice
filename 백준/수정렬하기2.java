import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 수정렬하기2 {

    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
       int n=Integer.parseInt(br.readLine());

       PriorityQueue<Integer> pq=new PriorityQueue<>();
       while(n>0){
        pq.add(Integer.parseInt(br.readLine()));
        n--;
       }

       while(!pq.isEmpty()){
        bw.append(pq.poll()+"\n");
       }

       bw.flush();
       bw.close();
       br.close();


    }
}