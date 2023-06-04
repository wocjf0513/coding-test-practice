
import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_1149_dfs {

        static int[][] cost;
        static int min_cost=1000*1000;
    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        int a=in.nextInt();

        cost=new int[a][3];

        for(int i=0; i<a; i++){
            cost[i][0]=in.nextInt();
            cost[i][1]=in.nextInt();
            cost[i][2]=in.nextInt();
        }

        dfs(a,0,4,0);

     
        System.out.println(min_cost);
    }
    
    public static void dfs(int limit, int deepth, int choice, int cost_temp){

        if(deepth==limit){
            if(min_cost>cost_temp)
            min_cost=cost_temp;
            return;
        }
        else{
        for(int i=0; i<3; i++){
            if(choice!=i){
            choice=i;
            cost_temp+=cost[deepth][i];
            deepth+=1;
            dfs(limit,deepth,choice,cost_temp);
            deepth-=1; 
            cost_temp-=cost[deepth][i];
            choice=4;
            }
        }
    }
}
    
}
