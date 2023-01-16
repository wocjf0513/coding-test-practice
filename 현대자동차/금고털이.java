

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 금고털이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        long w=Long.parseLong(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        long[][] bag=new long[n][2];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            bag[i][0]=Long.parseLong(st.nextToken());
            bag[i][1]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(bag,new Comparator<long[]>() {

            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o2[1]-o1[1]);
            }

        });

    
        long cost=0;

       for(int i=0; i<n; i++){
            if(w>=bag[i][0]){
                cost+=bag[i][1]*bag[i][0];
                w=w-bag[i][0];
            }
            else{
                cost+=bag[i][1]*w;
                w=0;
            }
            if(w==0)
            break;
        }

        System.out.println(cost);
    
    }
}
