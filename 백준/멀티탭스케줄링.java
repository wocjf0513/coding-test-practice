import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        
        int[] nList=new int[k+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=k; i++){
            nList[i]=Integer.parseInt(st.nextToken());
        }
        scheduling(nList, n);
        

    }
    public static void scheduling(int[] list, int size){
        int count=0;
        ArrayList<Integer> store=new ArrayList<>();
        int[] idx=new int[size];

        for(int i=1; i<list.length; i++){
            boolean isContain=false;
            for(int j=0; j<store.size(); j++){
                if(store.get(j)==list[i])
                isContain=true;
            }

            if(isContain){

            }
            else{
                if(store.size()==size){
                    ArrayList<Integer> copy=new ArrayList<>();
                    for(int k=0; k<store.size(); k++)
                    copy.add(store.get(k));
                    for(int k=i+1; k<list.length; k++){
                        if(copy.size()==1)
                        break;
                        for(int t=0; t<size; t++){
                            if(store.get(t)==list[k]){
                            copy.remove(Integer.valueOf(list[k]));
                            break;
                            }
                        }
                    }
                    store.remove(copy.get(0));
                    count++;
                }

                store.add(list[i]);
            }
        }
        System.out.println(count);
        

    }
}
//멀티탭이 다 찼을 때, 새로운 걸 써야할 때, 이후 가장 빨리 써야할 거는 빼지 않는다. 최대 갯수만큼 고려해  
