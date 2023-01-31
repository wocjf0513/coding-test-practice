import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도서관 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[] bookP=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            bookP[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bookP);


        int positiveIdx=0;
        int sumMove=0;

        for(int i=0; i<n; i++){
            if(bookP[i]>0){
            positiveIdx=i;
            break;
            }
        }

        if(Math.abs(bookP[0])<Math.abs(bookP[n-1])){
            
        }
        else{

        }

     

    }
}
