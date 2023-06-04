package 아주대학교;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class 단어우월효과 {
    
    //첫번째 글자와 두번째 글자
    //글자수가 같다.
    //어렵다...시간초과
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());

        HashMap<String,ArrayList<String>> map=new HashMap<>();
        
        
        
        
        for(int i=1; i<=n; i++){
            String s=br.readLine();
            String newS=s.charAt(0)+s.charAt(s.length()-1)+"";
            if(!map.containsKey(newS))
            map.put(newS,new ArrayList<>());
            map.get(newS).add(s);   
        }

        int m=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=1; i<=m; i++)
        {   String s=st.nextToken();
            map.get(s.charAt(0)+s.charAt(s.length()-1)+"").forEach((x)->{
                if(x.length()==s.length()){
                }
            });
        }


        br.close();

    }

}
