import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크게만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        String s=br.readLine();
        List<Integer> input=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            input.add(s.charAt(i)-'0');
            list.add(input.get(i));
        }

        Collections.sort(list,Collections.reverseOrder());

        int remain=n-k;
    
        StringBuilder sb=new StringBuilder();

        while(sb.length()<remain){
            int bigN=list.get(0);
            int idx=input.indexOf(bigN);
            int realRemain=remain-sb.length();

            int localRemain=input.size()-idx;
            
            if(localRemain>=realRemain && idx!=-1){
                if(localRemain==realRemain){
                    for(int i=idx; i<input.size(); i++)
                    sb.append(input.get(i));
                    break;
                }
                sb.append(bigN);
                input=input.subList(idx+1, input.size());
                list.remove(0);
                
            }
            else{
                list.remove(0);
            }
        }
        bw.append(sb.toString());
        bw.flush();
        bw.close();
        br.close();

        //하나는 소팅, 하나는 입력 배열
        //가장 큰 숫자로부터 뒤에 있는 숫자가 n-k개면 채택
        //아니면 다음 큰 숫자로부터 뒤에있는 숫자
        //반복
    }
    
}
