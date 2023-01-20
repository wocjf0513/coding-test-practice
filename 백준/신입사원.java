import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class 신입사원 {


    //1억번 == 1초 
    public static void main(String[] args) throws IOException{
        //1차 서류 2차 면접
        //모든 지원자와 비교했을 때, 떨어지면 안된다.
        //서류만 sorting해서 맨앞에 있는 지원자는 다음 지원보다 면접 점수가 다 높아야 됨.

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){

            int n=Integer.parseInt(br.readLine());
            int resume[]=new int[n+1];
            

            //서류 심사, 면접 성적

            for(int j=0; j<n; j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                resume[a]=b;
            }

        int result=n;

        //index뒤에있는 값과는 비교할 필요 없음.
        //앞에있는 값과는 비교해서 면접 점수가 높아야됨.
        int min=Integer.MAX_VALUE;
            for(int j=1; j<=n; j++){
                if(resume[j]<min)
                min=resume[j];
                else{
                result--;
                }
            }
        //시간을 줄여야 함...

        
        bw.write(result+"\n");
        }
        bw.close();
        br.close();

    }
}
