import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 백줌5와6의차이{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] list=br.readLine().split(" ");
        
        long small=seeFive(list[0])+seeFive(list[1]);
        long big=seeSix(list[0])+seeSix(list[1]);

        System.out.println(small+" "+big);
        
        
    }
    public static int seeFive(String s){
        String new_s="";
        for(char c:s.toCharArray()){
            if(c=='6')
            new_s+='5';
            else
            new_s+=c;
        }
        
        return Integer.parseInt(new_s);

    }
    public static int seeSix(String s){
        String new_s="";
        for(char c:s.toCharArray()){
            if(c=='5')
            new_s+='6';
            else
            new_s+=c;
        }

        return Integer.parseInt(new_s);
    }
}