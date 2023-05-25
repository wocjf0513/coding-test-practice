import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 캠핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=new String[3];
        int temp=1;
        while(true){
            str=br.readLine().split(" ");
            int L=Integer.parseInt(str[0]);
            int P=Integer.parseInt(str[1]);
            int V=Integer.parseInt(str[2]);
            if(L==0 && P==0 && V==0)
            break;
            if((V%P)>L)
            V=V-(V/P)*(P-L)-(V%P-L);
            else
            V=V-(V/P)*(P-L);
            System.out.printf("Case %d: %d\n",temp,V);
            temp++;
        }
    }
}
