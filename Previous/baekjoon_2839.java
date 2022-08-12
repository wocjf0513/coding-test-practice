import java.util.*;


public class baekjoon_2839{
    

    // 3을 담을  수 있는 x , 5를 담을 수 있는 y
    // x가 작을 수록 봉지의 수가 적어지는 것이므로
    // 3*x+5*y는 n인 조건을 만족하는 경우에서 x를 1씩 늘려주면서 
    // y가 정수가 되는 값을 찾는다.

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(envelope(n));
    }
    public static int envelope(int n){
        float x,y;
        x=0;
        y=0;

        while(true){
            y=(n-3*x)/5;
            if(y-(int)y==0 && (3*x+5*y)==n){
                return (int)(x+y);
            }
            x++;
            if(3*x>n)
            return -1;
        }
    }
}