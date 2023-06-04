import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 커트라인 {
    //k번째인 사람
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int applicant=sc.nextInt();
        int prize=sc.nextInt();

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<applicant; i++)
        list.add(sc.nextInt());

        list.sort(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
            
        });

        System.out.println(list.get(prize-1));
        
    }
    
}
