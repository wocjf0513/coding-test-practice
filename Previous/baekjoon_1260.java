import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_1260 {

    static ArrayList<Integer> dfs_list;
    static ArrayList<Integer> bfs_list;
    static ArrayList<Integer> check_list;
    static int[][] squre;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int v=in.nextInt();

        dfs_list=new ArrayList<>();
        bfs_list=new ArrayList<>();
        check_list=new ArrayList<>();

        squre=new int[n+1][n+1];

        int ori=0,goal=0;
        for(int i=0; i<m; i++){
            ori=in.nextInt();
            goal=in.nextInt();

            squre[ori][goal]=1;
            squre[goal][ori]=1;
        }

        dfs(v);
        bfs_list.add(v);
        bfs(v);

        for(int i:dfs_list.stream().mapToInt(i -> i).toArray()){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i:bfs_list.stream().mapToInt(i -> i).toArray()){
            System.out.print(i+" ");
        }

    }
    public static void dfs(int v){
        dfs_list.add(v);
        for(int i=1; i<=squre.length-1; i++){
            if(squre[v][i]==1 && !dfs_list.contains(i)){
                dfs(i);
            }
        }

    }
    public static void bfs(int v){
        int temp=0;
        
        for(int i=1; i<=squre.length-1; i++){
            if(squre[v][i]==1 && !check_list.contains(i) && !bfs_list.contains(i)){
                check_list.add(i);
                bfs_list.add(i);
            }
        }
        if(!check_list.isEmpty()){
            temp=check_list.get(0);
            check_list.remove(0);
            bfs(temp);
        }

    }
}
