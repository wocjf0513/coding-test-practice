import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 구구단걷기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            long n=Long.parseLong(br.readLine());
            long min=Long.MAX_VALUE;
            for(long j=1; j<=Math.sqrt(n); j++){
                if(n%j==0){
                    long temp=(n/j)+j;
                    
                    if(min>temp){
                        min=temp;
                    }
                }
            }

            bw.append("#"+i+" "+(min-2)+"\n");

        }
        bw.flush(); bw.close(); br.close();
    }
    
}
