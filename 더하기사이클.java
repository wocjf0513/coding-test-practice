import java.util.Scanner;



public class 더하기사이클 {
    public static void main(String[] args) {
        //두자리를 수를 만든다
        //각각을 더한다
        //주어진 수의 일의 자리수 + 더한 수의 일의 자리수 (이어붙이는)
        //이를 반복해 몇번 만의 주어진 수를 복구할 수 있는가?

        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();

        addCycle(input, 0, input);

    }
    public static void addCycle(int input, int count, int origin){
        int result=(input%10)*10+(input/10+input%10)%10;
        count+=1;
        if(origin==result){
        System.out.println(count);
        return;
        }

        else
        addCycle(result, count, origin);
        
    }   
}
