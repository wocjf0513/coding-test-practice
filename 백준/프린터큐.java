import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프린터큐{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken()); //문서 개수
            int m=Integer.parseInt(st.nextToken()); //찾고자 하는 문서 인덱스

            int count=0;

            Deque<Integer> dq=new LinkedList<>();
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

            st=new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                int value=Integer.parseInt(st.nextToken());
                dq.add(value);
                pq.add(value);
            }

        
            while(true){

                if(m==0){
                    if(dq.getFirst()==pq.peek()){
                        bw.append((count+1)+"\n");
                        break;
                    }
                    else{
                        int temp=dq.poll();
                        dq.add(temp);
                        m=n-count-1;
                    }
                }
                else{
                    if(dq.getFirst()==pq.peek()){
                        dq.poll();
                        pq.poll();
                        count++;
                        m--;
                    }
                    else{
                        int temp=dq.poll();
                        dq.add(temp);
                        m--;
                    }

                }
            }

            bw.flush();
            

            /*
            1) 맨 앞이 찾고자 하는 문서 일때
            맨 앞이 가장 큰 거면 count+1 이 답!
            맨 앞이 큰 게 아니면 m=n-count-1; 
            2) 아닐때
            맨 앞이 가장 큰 거면 count++ , m--
            맨 앞이 큰 게 아니면 m--
            */
        }
    }
}