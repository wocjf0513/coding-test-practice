import java.io.*;
import java.util.StringTokenizer;
class Main {

    static int jump[][];
    static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int j=Integer.parseInt(st.nextToken());

        int check[]=new int[n];

        jump=new int[j][2];

        for(int i=0; i<j; i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0; k<2; k++)
            jump[i][k]=Integer.parseInt(st.nextToken());
        }
        int current=0;
        //0부터 n-1까지

        dfs(n-1,0,current,check);
        
        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        else{
            System.out.println(min);
        }



	}
    public static void dfs(int goal, int count, int current, int[] check ){
        if(current>=goal){
            if(count<min)
            min=count;
            return;
        }

        for(int i=1; i<=6; i++){
            int previous=current;
            current+=i;
            count++;
            for(int j=0; j<jump.length; j++){
                if(current==jump[j][0])
                {
                    current=jump[j][1];
                }
            }
            //점프
            if(current>=goal){
                dfs(goal,count,current,check);
            }
            else{
            if(check[current]==1){
            }
            else{
                check[current]=1;
                dfs(goal,count,current,check);
                check[current]=0;
            }
        }
            current=previous;
            count--;
        }
    }
}
//무한반복 구간 시 -1 출력