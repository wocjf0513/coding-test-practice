package 아주대학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class APC는쉬운난이도순일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        String[] tiers=new String[n];
        String[] input=new String[n];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            tiers[i]=st.nextToken();
            input[i]=tiers[i];
        }

        Arrays.sort(tiers, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                ArrayList<Character> tier2=new ArrayList<>();
                tier2.add('B'); tier2.add('S'); tier2.add('G'); tier2.add('P'); tier2.add('D');
                
                if(o1.charAt(0)==o2.charAt(0)){
                    return Integer.parseInt(o2.substring(1, o2.length())) - Integer.parseInt(o1.substring(1, o1.length()));
                }
                else{
                    return tier2.indexOf(o1.charAt(0))-tier2.indexOf(o2.charAt(0));
                }
            }
            
        });
        
        //정렬이 이루어진다음 틀린 두개를 찾고 순서를 바꿔서 출력. 
        //안 틀렸으면 OK

        boolean succeed=true;

        StringBuilder sb=new StringBuilder();
        

        for(int i=0; i<n; i++){
            if(tiers[i]!=input[i])
            {
                sb.append(tiers[i]+" ");
                succeed=false;
            }
        }
        if(succeed==false){
            System.out.println("KO");
            sb.deleteCharAt(sb.length()-1);
            System.out.print(sb.toString());
        }
        else
        System.out.println("OK");


    }
    //브론즈 1 > 브론즈 100
}
