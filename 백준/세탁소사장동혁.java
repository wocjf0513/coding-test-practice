import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 세탁소사장동혁 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());

        while(t>0){
            int n=Integer.parseInt(br.readLine());

            int quarter=n/25;
            int remain=n%25;

            int dime=remain/10;
            remain=remain%10;

            int nickel=remain/5;
            remain=remain%5;
 
            int penny=remain/1;
            

            bw.append(quarter+" "+dime+" "+nickel+" "+penny+"\n");  
            
            t--;

        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
}
