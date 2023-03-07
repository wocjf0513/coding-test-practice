import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 국회의원선거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[] inputList=new int[n];

        for(int i=0; i<n; i++){
            inputList[i]=Integer.parseInt(br.readLine());
        }

        int idx=0;
        int ans=0;
        
        while(true){
            idx=maxCal(inputList);
            if(idx==0){
                break;
            }
             inputList[idx]--;
             inputList[0]++;
             ans++;
        }
        System.out.println(ans);

    }
  
    public static int maxCal(int[] temp){
        int idx=0;
        int max=0;
        for(int i=0; i<temp.length; i++){
            if(temp[i]>=max)
            {
                max=temp[i];
                idx=i;
            }  
        }
        return idx;
    }

    
}
