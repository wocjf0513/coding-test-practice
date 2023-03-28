import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 홀수만더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=t; i++){
            long ans=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=10; j++){
                int temp=Integer.parseInt(st.nextToken());
                if(temp%2==1)
                ans+=temp;
            }

            bw.append("#"+i+" "+ans+"\n");
        }
        bw.flush(); bw.close(); br.close();

    }
    
}
