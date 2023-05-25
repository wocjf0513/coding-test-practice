import java.util.Arrays;
import java.util.Scanner;

public class 기타줄 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] input_p=new int[m];
        int[] input_u=new int[m];
        
        for(int i=0; i<m; i++)
        {
            input_p[i]=sc.nextInt();
            input_u[i]=sc.nextInt();
        }

        int pack_num=0;
        pack_num=n/6;
        
        int piece_num=0;
        piece_num=n%6;

        int cost=0;

        Arrays.sort(input_p);
        Arrays.sort(input_u);

        if(input_p[0]<input_u[0]*6)
        cost+=input_p[0]*pack_num;
        else
        cost+=pack_num*input_u[0]*6;

        if(input_p[0]<input_u[0]*piece_num)
        cost+=input_p[0];
        else
        cost+=input_u[0]*piece_num;
   

        System.out.println(cost);
        sc.close();
        
    }
    
}
