import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NM찍기 {
    

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=sc.nextInt(); int m=sc.nextInt();

        int cnt=1;

        while(n>0){
            for(int i=0; i<m; i++){
                if(i!=m-1)
                bw.append(cnt+" ");
                else
                bw.append(Integer.toString(cnt));
                cnt++;
            }
            bw.append("\n");
            n--;
        }

        bw.flush();
        bw.close();
        sc.close();;

        

        
    }
}
