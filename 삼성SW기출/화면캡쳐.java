import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 화면캡쳐 {

    public static void main(String[] args) throws IOException {
        //100.000.0000

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            long n=Long.parseLong(br.readLine());
            bw.append("#"+i+" ");

            int cnt=0; 

            long temp=1;

            Deque<Long> dq=new LinkedList<>();

            dq.push(temp);
            bw.append(temp+".png ");
            cnt++;
            while(true){
                

                if(temp*10<=n){
                    temp=temp*10;
                    dq.push(temp);
                    bw.append(temp+".png ");
                    cnt++;
                }
                else{
                    temp=dq.pop();
                    if(temp+1<=n){
                    temp=temp+1;
                    if(!dq.isEmpty() && String.valueOf(dq.peek()+1).compareTo(String.valueOf(temp))>0){
                    dq.push(temp);
                    bw.append(temp+".png ");
                    cnt++;
                    }
                    else if(dq.isEmpty()){
                        dq.push(temp);
                        bw.append(temp+".png ");
                        cnt++;
                    }
                    }
                }


                if(cnt==50 || cnt==n)
                break;
            }

            bw.append("\n");

        }
        bw.flush(); bw.close(); br.close();
    }
    
}
