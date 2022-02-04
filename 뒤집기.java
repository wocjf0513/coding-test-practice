import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        //연속된 1의 개수와 연속된 0의 개수를 반환한다.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        int one_count=0;
        int zero_count=0;
        char pre='A';

        for(char c:str.toCharArray())
        {
            if(c!=pre){
                pre=c;
                if(c=='1')
                one_count++;
                if(c=='0')
                zero_count++;
            }
        }
        if(zero_count==0 || one_count==0)
        System.out.println(0);
        else
        System.out.println(Math.min(one_count,zero_count));
        
    }
    
}
