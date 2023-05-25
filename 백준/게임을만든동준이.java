import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을만든동준이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int len=n;
        int[] score=new int[n];
        while(n>0){
            score[len-n]=Integer.parseInt(br.readLine());
            n--;
        }
        int cnt=0;
        for(int i=len-2; i>=0; i--){
            if(score[i]>=score[i+1]){
            cnt+=score[i]-score[i+1]+1;
            score[i]=score[i+1]-1;
            } 
        }
        System.out.println(cnt);

    }
    
}
