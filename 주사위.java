import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

public class 주사위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine()); //크기의 정육면체
        StringTokenizer st=new StringTokenizer(br.readLine());

        long[] dice=new long[6];

        for(int i=0; i<6; i++){
            dice[i]=Long.parseLong(st.nextToken());
        }

        long minOne=Arrays.stream(dice).min().getAsLong();

        long minTwo=Long.MAX_VALUE;

        for(int i=0; i<6; i++){
            for(int j=i+1; j<6; j++){
                if(i!=j && i!=5-j){
                    if(dice[i]+dice[j]<minTwo)
                    minTwo=dice[i]+dice[j];
                }
            }
        }

        long minThree=Long.MAX_VALUE;

        
        for(int i=0; i<6; i++){
            for(int j=i+1; j<6; j++){
                for(int z=j+1; z<6; z++){
                    if(i!=j && j!=z && z!=i && i!=5-j && i!=5-z && j!=5-z){
                        if(dice[i]+dice[j]+dice[z]<minThree)
                        minThree=dice[i]+dice[j]+dice[z];
                    }
                }
            }
        }

        //계산
        long ans= minThree*4+ (8*(n-2) + 4)*minTwo+ minOne*(5*((n-2)^2) + 4*(n-2));

        
        System.out.println(ans);

        
        /* 
         * n==2 20면
         * 3면을 보여주는 주사위 4개
         * 2면을 보여주는 주사위 4개
         * 총 보여지는 면 20개
         * 
         * n==3 45면
         * 3면을 보여주는 주사위 4개
         * 1면을 보여주는 주사위 9개
         * 2면을 보여주는 주사위 12개
         * (n-1)*4+1 
         */



    }
    
}
