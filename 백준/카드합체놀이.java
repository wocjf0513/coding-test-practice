import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int cardN=Integer.parseInt(st. nextToken());
        int mixN=Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq=new PriorityQueue<>();
        st=new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            pq.add(Long.parseLong(st.nextToken()));
        }
        for(int i=0; i<mixN; i++){
            long first=pq.poll();
            long second=pq.poll();
            long sum=first+ second;
            pq.add(sum);
            pq.add(sum);
        }
        long answer=0;
        Iterator<Long> it=pq.iterator();

        while(it.hasNext())
        answer+=it.next();


        bw.append(answer+"");
        bw.close();
        br.close();

    }
    
}
