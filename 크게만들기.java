import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크게만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        String num=br.readLine();

        int idx=0;

        for(int i=0; i<num.length()-k; i++){
            int max=0;
            for(int j=idx; j<=i+k; j++){
                if(max<num.charAt(j)-'0'){
                    max=num.charAt(j)-'0';
                    idx=j+1;
                }
            }
        
            bw.append(max+"");
        }

      
        
        bw.flush();
        bw.close();
        br.close();

        //가장 큰 숫자(뒤에 남아야 되는 개수이상 있는)
        //찾은 숫자 앞에는 안보기

        //아니면 다음 큰 숫자로부터 뒤에있는 숫자
        //반복
    }
    
}
