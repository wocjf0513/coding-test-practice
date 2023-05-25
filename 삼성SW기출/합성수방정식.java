import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 합성수방정식 {

    public static void main(String[] args) throws IOException{
        
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int t=Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++){
            long y=0,x=0;
            long n=Integer.parseInt(br.readLine());
            //x-y=m

            for(y=4; y<=1000000000; y++){
                x=y+n;
                if(x<=1000000000 && !isPrime(x) && !isPrime(y)){
                    break;
                }
            }

            bw.append("#"+i+" "+x+" "+y+"\n");
        }
        bw.flush();bw.close();br.close();

        
    }
    public static boolean isPrime(long x){

        for(int j=2; j<=Math.sqrt(x); j++){
            if(x%j==0){
                return false;
            }
        }
        return true;

    }
    
}
