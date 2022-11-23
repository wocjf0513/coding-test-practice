import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class 가까운사이의두점 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        ArrayList<Integer> list=new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int diff=Integer.MAX_VALUE;
        int index=0;

        for(int i=1; i<list.size(); i++){
            int diff2=list.get(i)-list.get(i-1);
            if(diff>diff2){
                diff=diff2;
                index=i;
            }
        }
        System.out.println(list.get(index-1)+" "+list.get(index));


    }
}