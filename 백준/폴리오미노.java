import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노 {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine(); StringBuilder sb=new StringBuilder(); StringBuilder ans=new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='X'){
                sb.append("A");
                if(i==input.length()-1){
                    if(sb.length()%2==0){
                        ans.append(change(sb));
                    }
                    else{
                        System.out.println(-1);
                        return;
                    }
                    
                sb=new StringBuilder();
                }
            }
            else{
                //변환
                
                if(sb.length()%2==0){
                    ans.append(change(sb));
                }
                else{
                    System.out.println(-1);
                    return;
                }
                ans.append(".");
                
                sb=new StringBuilder();

            }
        }
        System.out.println(ans.toString());

    }
    public static String change(StringBuilder source){
        if(source.length()==0){
            return source.toString();
        }
        else{
            if(source.length()%4==2){
            source.delete(source.length()-2, source.length());
            source.append("B"); source.append("B");
            }
            return source.toString();
        }
        
    }
}
