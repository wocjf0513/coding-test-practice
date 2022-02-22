import java.io.IOException;
import java.util.Scanner;

public class Main {

    static long min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int input[]=new int[2];
        input[0]=sc.nextInt();
        input[1]=sc.nextInt();
        bfs(input[0],input[1],1);

        if(min==Integer.MAX_VALUE)
        System.out.println(-1);
        else
        System.out.println(min);
    }
    public static void bfs(long source, long goal, long count){
        if(source>goal)
        {
            return ;
        }
        else if(source==goal)
        {
            if(min>count)
            min=count;
        }
        else
        {
            bfs(source*2,goal,count+1);
            long new_source=Long.parseLong(source+"1");
            bfs(new_source,goal,count+1);
           
        }

    }
    
    
}
