import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 파도반수열{

    static int[] input;
    static long[] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        input=new int[n];
        triangle=new long[101];
        for(int i=0; i<n; i++){
            input[i]=Integer.parseInt(br.readLine());
        }
        triangle[1]=1;
        triangle[2]=1;
        triangle[3]=1;
        triangle[4]=2;
        triangle[5]=2;

        for(int i=6; i<=100; i++){
            triangle[i]=triangle[i-1]+triangle[i-5];
        }

        for(int i=0; i<n; i++){
            System.out.println(triangle[input[i]]);
        }


    }
}