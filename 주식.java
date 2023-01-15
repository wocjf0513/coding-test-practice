import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());

        while(t>0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            int arr[]=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());

            }

            long profit=0;
            int maxCost=0;
            maxCost=arr[n-1];
            for(int i=n-1; i>=0; i--){
                //cost 보다 작으면 팔아!!
                if(arr[i]<maxCost)
                profit+=maxCost-arr[i];
                else
                   maxCost=arr[i];
            }

            bw.append(profit+"\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
