import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 이친수는 0으로 시작하지 않는다.
// 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

// n=1 , 1
// n=2 , 10 
// n=3 , 101 , 100 
// n=4 , 1010, 1001, 1000 앞 단계에 숫자가 마지막 0으로 끝나면 1이나 0을 붙일 수 있고, 1로 끝나면 0만 붙일 수 있다.

//자료형: 1~90, 

class 이친수{
    public static void main(String args[]) throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        long[][] two_num=new long[91][2];

        for(int i=1; i<=90; i++){
            if(i==1){
                two_num[i][1]=1;
            }
            else{
                long temp_num=two_num[i-1][0];
                two_num[i][1]+=temp_num;
                two_num[i][0]+=two_num[i-1][1]+temp_num;

            }
        }
        
        System.out.println(two_num[n][0]+two_num[n][1]);


    }
}