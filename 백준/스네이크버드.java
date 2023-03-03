import java.util.PriorityQueue;
import java.util.Scanner;

public class 스네이크버드 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); int len=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1; i<=n; i++)
        pq.add(sc.nextInt());

        while(!pq.isEmpty()){
            if(len>=pq.poll())
                len++;
            else
            break;
        }
        System.out.println(len);
    }
    
}
