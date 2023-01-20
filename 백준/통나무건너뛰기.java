import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 통나무건너뛰기 {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=sc.nextInt();

        
        while(t>0){
            int n=sc.nextInt();
            PriorityQueue<Integer> pqH=new PriorityQueue<>(Collections.reverseOrder());
        
            int[] newArray=new int[n];
            // 0 0 0 0 0 0
            
            for(int i=1; i<=n; i++){
                pqH.add(sc.nextInt());
            }
            
            if(n%2==0){
                //짝수일 때
                int i=0;
                while(!pqH.isEmpty()){
                    newArray[n/2+i]=pqH.poll();
                    newArray[(n/2-1)-i]=pqH.poll();
                    i++;
                }
            }
            else{
                //홀수 일때
                newArray[n/2]=pqH.poll();
                int i=1;
                while(!pqH.isEmpty()){
                    newArray[n/2+i]=pqH.poll();
                    newArray[n/2-i]=pqH.poll();
                    i++;
                }

            }

            int diff=Math.abs(newArray[n-1]-newArray[0]);

            for(int i=0; i<n-1; i++){
                int Ldiff=Math.abs(newArray[i+1]-newArray[i]);
                if(diff<Ldiff)
                diff=Ldiff;
            }
        
            bw.append(diff+"\n");

            
            
            // 1 1 1 1 1 1
            
            t--;
        }
        bw.flush();
        bw.close();
        
        //가운데부터 큰거 정렬
        
    }
    
}
