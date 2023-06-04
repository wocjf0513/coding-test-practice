import java.util.ArrayList;
import java.util.Scanner;

public class test {

    static int n;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int[] list=new int[n];
        for(int i=0; i<n; i++){
            list[i]=sc.nextInt();
        }
        //showList(list, 0, new ArrayList<Integer>());

        showList2(list, 0, new ArrayList<Integer>());
    }
    
    public static void showList(int[] list, int idx, ArrayList<Integer> que){
        
       

        que.stream().forEach(x->System.out.print(x+" "));
        System.out.println();

        for(int i=idx; i<n; i++){
            que.add(Integer.valueOf(list[i]));
            showList(list, i+1, que);
            que.remove(Integer.valueOf(list[i]));
        }
        
    }

    public static void showList2(int[] list, int idx, ArrayList<Integer> que){

        if(idx==list.length){
            if(!que.isEmpty()){
            que.stream().forEach(x->System.out.print(x+" "));
            System.out.println();
            }
            return;
        }


        que.add(Integer.valueOf(list[idx]));
        showList2(list, idx+1, que);
        que.remove(Integer.valueOf(list[idx]));
        showList2(list, idx+1, que);
              
        
        
    }
}
