import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 단어우월효과 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //알파벳 26개
        //글자수 8이하
        String[][][] table=new String[26][26][8];
        
        for(int i=0; i<n; i++){
            String temp=br.readLine();
            int fc=temp.charAt(0)-'a';
            int len=temp.length()-1;
            int sc=temp.charAt(len)-'a';
            table[fc][sc][len]=temp;
        }

        int m=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        String ans="";

        
        for(int i=0; i<m; i++){
            String temp=st.nextToken();
            int fc=temp.charAt(0)-'a';
            int len=temp.length()-1;
            int sc=temp.charAt(len)-'a';
            ans+=table[fc][sc][len]+" ";
            //charAt이 마지막 idx까지 돈다.
        }
        System.out.println(ans);
    }
    
}
