import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class 이항계수2{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String buf=br.readLine();
        int[] arr=Arrays.stream(buf.split(" ")).mapToInt(Integer::parseInt).toArray();


        long[][] binomical=new long[1002][1002];

        // n!/ (n-k)!k!
        // 1<=n 0<=k
        //    0 1 2 3 4 5
        //1   1 1
        //2   1 2 1
        //3   1 3 3 1

        binomical[0][0]=1;


        for(int i=1; i<=arr[0]; i++){
            for(int j=0; j<=arr[0]; j++){
                if(j==0 || j==arr[0])
                binomical[i][j]=1;
                else
                binomical[i][j]=(binomical[i-1][j-1]+binomical[i-1][j])%10007;
            }
        }
        System.out.println(binomical[arr[0]][arr[1]]);
    }
}