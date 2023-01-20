import java.util.Scanner;

public class 스타트와링크 {
    static int[][] list;
    static int n;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        list=new int[n][n];
        int member[]=new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                list[i][j]=sc.nextInt();
            }
        }
        dfs(member,0);

        System.out.println(min);
        
    }
    public static void dfs(int[] mem, int level){
       //순서에 상관없이 같은 수열은 cal이 되면 시간이 많이 걸린다!!

        if(level==n/2)
        {
            int temp=cal(mem);
            if(min>temp)
            min=temp;
            return ;
        }
        for(int i=0; i<n; i++){
            if(mem[i]==0){
            mem[i]=1;
            dfs(mem,level+1);
            mem[i]=0;
            }
        }
        
    }
    public static int cal(int[] mem){
        int start=0;
        int link=0;
        for(int i=0; i<mem.length; i++){
            if(mem[i]==0){
                //스타트
                for(int j=0; j<mem.length; j++)
                if(mem[j]==0)
                    start+=list[i][j];
            }
            else{
                //링크
                for(int j=0; j<mem.length; j++)
                if(mem[j]==1)
                    link+=list[i][j];

            }
        }
        return Math.abs(start-link);
    }
    
}
