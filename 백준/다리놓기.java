import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] input=new int[n][2];
        for(int i=0; i<n; i++){
            String[] s=br.readLine().split(" ");
            input[i][0]=Integer.parseInt(s[0]);
            input[i][1]=Integer.parseInt(s[1]);
            if(input[i][0]<input[i][1]-input[i][0])
            System.out.println(fact(input[i][1],input[i][1]-input[i][0])/(fact(input[i][0],1)));
            else
            System.out.println(fact(input[i][1],input[i][0])/(fact(input[i][1]-input[i][0],1)));
        }
    }
    public static long fact(int n, int end){
        if(n<=end)
        return 1;
        else
        return fact(n-1,end)*n;
    }
}
