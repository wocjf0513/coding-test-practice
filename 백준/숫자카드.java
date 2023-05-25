import java.util.HashMap;
import java.util.Scanner;

class 숫자카드{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        
        StringBuilder sb=new StringBuilder();

        HashMap<Integer,Integer> mList=new HashMap<>();

        for(int i=0; i<m; i++)
        mList.put(sc.nextInt(), 1);

        int M=sc.nextInt();

        for(int i=0; i<M; i++)
        {
            if(mList.containsKey(sc.nextInt()))
            sb.append("1 ");
            else
            sb.append("0 ");
        }
        System.out.println(sb.toString());
        
    }
}