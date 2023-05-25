
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class baekjoon_2667 {
    //bfs는 dfs와 같이 작동되지 않는다. bfs함수 안에 bfs를 넣지 않는다.
    //bfs를 통해 각자 인접한 1을 visited에 true하면서 갯수를 셀 수 있다.
    //bfs와 dfs는 다른 알고리즘보다 하나씩 따져가면서 할 필요가 있다.    
    static int[][] data;
    static int[] direction=new int[]{-1,+1,0,0};
    static int[] direction2=new int[]{0,0,-1,+1};
    static boolean[][] visited;
    static int[] apart=new int[25*25];
    static int apartnum=0;
    
    static Stack<int[]> stack=new Stack<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,n=sc.nextInt();
        
        visited=new boolean[n][n];

        data=new int[n][n]; 
        for(i=0; i<n; i++){
            String input = sc.next();
            for(j=0; j<n; j++){
                data[i][j] = input.charAt(j)-'0';
             }
        }
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(data[i][j] == 1 && !visited[i][j]){
                    apartnum++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(apart);
        System.out.println(apartnum);
        for(i=0; i<apart.length; i++){
            if(apart[i] != 0){
                
                System.out.println(apart[i]);
            }
        }


        sc.close();;
   
    }
    public static void bfs(int c, int r){
        
        stack.push(new int[]{c,r});
        visited[c][r]=true;
        apart[apartnum]++;  

        while(!stack.empty()){
            
            int temp[]=stack.pop();

        for(int i=0; i<4; i++){
            int chaC=direction[i]+temp[0];
            int chaR=direction2[i]+temp[1];
            
            if(0<=chaR && chaR<data.length && 0<=chaC && chaC<data.length)
            if(!visited[chaC][chaR] && data[chaC][chaR]==1){
            stack.push(new int[]{chaC,chaR});
            visited[chaC][chaR]=true;
            apart[apartnum]++;
            }
            
        }
        
    }

    }
}
