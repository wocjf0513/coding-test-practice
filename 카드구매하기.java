import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String arr[]=br.readLine().split(" ");
        int input[]=Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int max[]=new int[n];

        int temp=0;

        for(int i=0; i<n; i++){
            if(i==0)
            max[i]=input[i];
            else if(i==1){
                if(max[i-1]*2<input[i])
                max[i]=input[i];
                else
                max[i]=max[i-1]*2;
            }
            else{
                max[i]=input[i];
                for(int j=1; j<=i/2+1;j++){
                max[i]=Math.max(max[i-j]+max[j-1],max[i]);
                }
            }
        }
        System.out.println(max[n-1]);

    }
    //1장 
    //2장 1장 두개랑 비교
    //3장 max[2]+ 1장이랑 비교
    //4장 max[3]+ 1장이랑 비교 max[2]*2랑 비교
    //5장 max[4]+1 이장 비교

}
