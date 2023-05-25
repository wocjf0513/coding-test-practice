import java.util.Scanner;



public class baekjoon_1436 {

    // dynamic schedule
    // 입력이 10으로 주워졌을 때, 1-> 3-> 9-> 10이 되는데 
    // 각 전 과정도 횟수가 최소화되어야지 10이 될때도 4로 최소화된다.

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input=in.nextInt();
        int[] dynamic=new int[input+1];
        for(int i=1; i<=input; i++){
            dynamic[i]=dynamic[i-1]+1;
            if(i%2==0)
                dynamic[i]=Math.min(dynamic[i],dynamic[i/2]+1);
            if(i%3==0)
                dynamic[i]=Math.min(dynamic[i],dynamic[i/3]+1);
            
        }
        System.out.println(dynamic[input]-1);
    }
}
