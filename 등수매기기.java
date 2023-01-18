import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 등수매기기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        boolean[] site=new boolean[n+1];

        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();


        for(int i=1; i<=n; i++){
            int temp=Integer.parseInt(br.readLine());

            if(site[temp] || n<temp){
                list.add(temp);
            }
            else
            site[temp]=true;
        }

        for(int i=1; i<=n; i++){
            if(!site[i])
            list2.add(i);
        }
        
        long unHappy=0;

        Collections.sort(list);
        Collections.sort(list2);
        
        for(int i=0; i<list.size(); i++){
            unHappy+=Math.abs(list.get(i)-list2.get(i));
        }

        System.out.println(unHappy);

        
        

    }
    
}
