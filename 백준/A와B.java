import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B {

    static boolean enable=false;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String goal=br.readLine();
        String source=br.readLine();


        goalToChange(goal, source);
        
        if(enable){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }



    }
    public static void goalToChange(String goal, String source){
      
        StringBuilder sb=new StringBuilder(source);

        if(goal.length()== sb.length()){
            if(goal.equals(sb.toString()))
                enable=true;
            return;
        }
        
        if(sb.charAt(sb.length()-1)=='B')
        {
            sb.deleteCharAt(sb.length()-1);
            sb=new StringBuilder(swap(sb.toString()));
        }
        else if(sb.charAt(sb.length()-1)=='A'){
            sb.deleteCharAt(sb.length()-1);
        }



        goalToChange(goal,sb.toString());
        

    }
    public static String swap(String s){
        StringBuilder sb=new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
}
