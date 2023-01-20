import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 과제 {

    static int scoreSum=0;

    //pq로 다 받기
    //가장 큰 인덱스부터 가장 큰 거 빼곤 전 인덱스에 que 물려주기

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        //0은 마감일, 1은 점수
        PriorityQueue<Integer>[] pq=new PriorityQueue[1001];
        int score[]=new int[1001];

        for(int i=0;i<=1000;i++){
            pq[i]=new PriorityQueue<Integer>(Collections.reverseOrder());
        }
        //생성 

        int max=0;

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int d=Integer.parseInt(st.nextToken());
            if(max<d)
            max=d;
            int s=Integer.parseInt(st.nextToken());
            pq[d].add(s);

        }

        for(int i=max; i>=1; i--){
            
            if(!pq[i].isEmpty()){
                score[i]=pq[i].poll();
                while(!pq[i].isEmpty()){
                    pq[i-1].add(pq[i].poll());
                }
            }
            else{
                continue;
            }
        }

        Arrays.stream(score).forEach(x->scoreSum+=x);
        
        System.out.println(scoreSum);

    }
    
}
