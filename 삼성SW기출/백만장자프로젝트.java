import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백만장자프로젝트{
    

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
            for(int c=1; c<=t; c++){
                int n=Integer.parseInt(br.readLine());
                int[] tagList=new int[n];
                PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
                //큰 수부터
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int i=0; i<n; i++){
                    int temp=Integer.parseInt(st.nextToken());
                    tagList[i]=temp;
                    pq.add(temp);    
                }
                int ans=0;
                for(int i=0; i<n; i++){
                    int temp=tagList[i];
                    ans+=pq.peek()-temp;
                    pq.remove(temp);
                }
                bw.append("#"+c+" "+ans+"\n");
                

                /*for문을 돌면서, pq.peek-해당 인덱스의 값을 이윤으로 적용
                근거는 첫번째 날 값부터 for문을 돌기 때문에 pq.peek은 해당 날 값이거나 첫번째 날 이후 값중 가장 큰 이윤을 남길 수 잇는 값이므로
                마지막으로 pq에서 해당 인덱스 값 삭제 후 반복!! 
                */

            }
        bw.flush();
        bw.close();
        br.close();
        }

    }