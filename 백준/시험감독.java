import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 시험감독 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        long[] testP=new long[n];

        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            testP[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());

        long b=Integer.parseInt(st.nextToken()); //총 감독

        long c=Integer.parseInt(st.nextToken()); //부 감독


        BigInteger viewer=BigInteger.ZERO;


            for(long people:testP){
                people=people-b;
                viewer=viewer.add(BigInteger.ONE);

                people=Math.max(people,0);

                long share =people/c;
                long reminder =people%c;

                if(reminder!=0){
                    share++;
                }
                viewer=viewer.add(BigInteger.valueOf(share));
                
            }


        System.out.println(viewer.toString());

        
    }

    
}
