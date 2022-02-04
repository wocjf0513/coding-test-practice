import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        long[] squre=new long[1001];
        squre[1]=1;
        squre[2]=3;

        for(int i=3; i<=1000; i++)
            squre[i]=(squre[i-1]+squre[i-2]*2)%10007;

        System.out.println(squre[n]);
        

    }
    
}
