import java.util.Scanner;

public class baekjoon_11726{

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
    //맨 끝에 1*2 블럭이 온다면 n - 1의 가로 길이를 가진 2*n타일의 경우의 수를 갖게 됩니다.
    //맨 끝에 2*1 블럭이 온다면, n - 2의 가로 길이를 가진 2*n타일의 경우릐 수를 가지게 됩니다.