import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();

        int min=0;
        String temp="";
        boolean inverse=false;

        
        for(int i=0; i<s.length(); i++){
            

            if(s.charAt(i)=='+'){
                if(inverse)
                min-=Integer.parseInt(temp);
                else
                min+=Integer.parseInt(temp);
                temp="";
            }
            else if(s.charAt(i)=='-'){
                if(inverse)
                min-=Integer.parseInt(temp);
                else{
                min+=Integer.parseInt(temp);
                inverse=true;
                }
                temp="";
            }
            else{
                temp+=s.charAt(i);
                if(i==s.length()-1){
                    if(inverse)
                    min-=Integer.parseInt(temp);
                    else
                    min+=Integer.parseInt(temp);
                }
            }

           
        }
        System.out.println(min);

}
    
}
