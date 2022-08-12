import java.util.Scanner;

public class baekjoon_11047{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] list=new int[n];
        for(int i=0; i<n; i++){
            list[i]=in.nextInt();
        }
        int quo=0;
        
        for(int i=list.length-1; i>=0; i--){
            if(k>=list[i]){
                quo+=k/list[i];
                k=k%list[i];
            }
        }
        System.out.println(quo);
    }

}