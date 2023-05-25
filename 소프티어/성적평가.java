import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 성적평가 {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] score=new int[n];
        int[] finalScore=new int[n];
        for(int i=0; i<4; i++){
            if(i==3){
            calPrize(finalScore);
            break;
            }
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){                
                score[j]=Integer.parseInt(st.nextToken());
                finalScore[j]+=score[j];
            }
            calPrize(score);
        }

        bw.flush();
        bw.close();
        br.close();
        



    }
    public static void calPrize(int[] scores) throws IOException{
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<scores.length; i++){
            pq.add(scores[i]);
        }

        HashMap<Integer,Integer> map=new HashMap<>();

        int Rate=1;
        while(!pq.isEmpty()){
            int temp=pq.poll();
            if(!map.containsKey(temp)){
                map.put(temp,Rate);
                Rate++;
            }
            else{
                Rate++;
            }
        }

        for(int i=0; i<scores.length; i++){
            if(map.containsKey(scores[i])){
                bw.append(map.get(scores[i])+" ");
            }
        }
        bw.append("\n");
    }
    
}
