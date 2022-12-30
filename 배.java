import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> crane=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        ArrayList<Integer> pq=new ArrayList<>();
        
        
        for(int i=1; i<=n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }
        crane.sort(Collections.reverseOrder()); //거꾸로 

        int b=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for(int i=1; i<=b; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        pq.sort(Collections.reverseOrder());

        //0번이 루트

    
        if(pq.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }
        
        int ans = 0;
    
        while(!pq.isEmpty()) {
            int idx =0;
            for(int i=0; i< n; ) {
                if(idx == pq.size()) break;
                else if(crane.get(i) >= pq.get(idx)) {
                    pq.remove(idx);
                    i++;
                }
                else idx++;
            }
            ans++;
        }
        System.out.println(ans);
    }
   
    
}
