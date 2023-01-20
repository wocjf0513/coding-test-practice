import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컵홀더 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String site=br.readLine();

        int c=0;
        for(int i=0; i<site.length(); i++){
            if(site.charAt(i)=='L')
                c++;
        }
        int minus=c/2-1;
        if(minus>0){
            System.out.println(n-minus);
        }
        else
        System.out.println(n);
    
    }
    
}
