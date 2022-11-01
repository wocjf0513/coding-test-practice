import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;



public class 신입사원 {


    public static void main(String[] args) throws IOException{
        //1차 서류 2차 면접
        //모든 지원자와 비교했을 때, 떨어지면 안된다.
        //서류만 sorting해서 맨앞에 있는 지원자는 다음 지원보다 면접 점수가 다 높아야 됨.

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){

            int n=Integer.parseInt(br.readLine());
            int list[]=new int[n+1];

            for(int j=0; j<n; j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                list[a]=b;
            }

        int result=n;

        for(int j=n; j>=1; j--){
            for(int k=j-1; k>=1; k--){
                if(list[j]>list[k]){
                    System.out.println(list[j]+" "+list[k]);
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
        }

    }
}
