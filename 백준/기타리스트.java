import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 기타리스트 {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        int[] v=new int[n+1];

        for(int i=1; i<=n; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        int[] volume=new int[m+1];
        ArrayList<Integer> list=new ArrayList<>();


        Arrays.fill(volume,-1);

        volume[s]=0;


        for(int i=1; i<=n; i++){
            list.clear();
            for(int j=0; j<=m; j++){
                if(volume[j]==i-1){
                    if(0<=(j-v[i]) && (j-v[i])<=m){
                        list.add(j-v[i]);
                    }
                    if(0<=(j+v[i]) && (j+v[i])<=m){
                        list.add(j+v[i]);
                    }
                } 
            }
            Iterator<Integer> it=list.iterator();
            while(it.hasNext()){
                volume[it.next()]=i;
            }
        }
        

        int max=-1; 

        for(int i=0; i<=m; i++){
            if(volume[i]==n){
                if(max<=i){
                    max=i;
                }
            }
        }

        System.out.println(max);

    }
    
}
