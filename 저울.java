import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {
    
    static int[] input;
    static int n;
    public static void main(String[] args)  throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        input=new int[n+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            input[i]=Integer.parseInt(st.nextToken());
        }

        //input[i]<=m+1 면 m까지 조합가능
        //input[i]>m+1 면 m+1 조합 안됨.

        Arrays.sort(input);
        long sum=0;
        boolean isStart=true;
            for(int i=1; i<=n; i++){
                if(input[i]<=sum+1)
                sum+=input[i];
                else{
                    System.out.println(sum+1);
                    isStart=false;
                    break;
                }
            }
        
    }
}
