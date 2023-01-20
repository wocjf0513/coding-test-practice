import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연결요소의개수{
    
    static int[] direction={0,0,+1,-1};
    static int[][] graph;
    static int count=0;
    static int[][] check;
    
    public static void main(String[] args) throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String[] s=br.readLine().split(" ");
       int n=Integer.parseInt(s[0]); int m=Integer.parseInt(s[1]);
       int pre,next;
       graph=new int[n][n];
       check=new int[n][n];

       for(int i=0; i<n; i++){
           graph[i][i]=1;
       }

       for(int i=0; i<m; i++){
           s=br.readLine().split(" ");
           pre=Integer.parseInt(s[0]);
           next=Integer.parseInt(s[1]);
           graph[pre-1][next-1]=1;
           graph[next-1][pre-1]=1;
       }
       //입력 잘 받아진다.

       
       for(int i=0; i<graph.length; i++){
        for(int j=0; j<graph.length; j++){
            if(graph[i][j]==1 && check[i][j]==0){
                dfs(i,j);
                count++;
            }
        }
    }
    
    System.out.println(count);
       
    }

    //이준 for문을 통해 1인 곳을 찾고 dfs 실행하고 count를 늘리자.
    public static void dfs(int x, int y){
        check[x][y]=1;
        for(int i=0; i<graph.length; i++){
            if(graph[y][i]==1 && check[y][i]==0){
                dfs(y,i);
            }
        }
      
    }
}
