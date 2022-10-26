import java.util.Scanner;

public class 하노이탑이동순서 {
    static int count=0;
    static StringBuilder sb= new StringBuilder();
 
    public static void main(String[] args) {
        //2 개 남앗을 때는 3단계를 거친다.
        //n-1개를 목적지에 두고 n을 옮기고 n-1을 옮긴다.
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        hanoi(k, 1, 2, 3);
        System.out.println(count);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

        
    }
    public static void hanoi(int k, int start, int mid, int end){
        if(k==1){
            count++;
            sb.append(start+" "+end+"\n");
            return;
        }
        hanoi(k-1, start, end, mid);
        sb.append(start+" "+end+"\n");
        count++;
        hanoi(k-1, mid, start, end);

    }
}