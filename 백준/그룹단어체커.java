import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] sList=new String[n+1];
        int count=0;
        for(int i=1; i<=n; i++){
            if(checkGroup(br.readLine()))
            count++;
        }
        System.out.println(count);


    }   
    public static boolean checkGroup(String s){
        char pre='.';
        ArrayList<Character> cList=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(!cList.contains(c))
            cList.add(c);
            else{
                if(pre!=c)
                return false;                
            }
            pre=c;
        }
        return true;

    }
}
