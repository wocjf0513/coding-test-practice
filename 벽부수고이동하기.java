import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    static int min=Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[] dir=new int[]{0,0,-1,+1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int[][]maps=new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            String temp=br.readLine();
            for(int j=1; j<=m; j++){
                maps[i][j]=(temp.charAt(j-1)-'0');
            }
        }
        int[][] check=new int[n+1][m+1];
        check[1][1]=1;

        dfs(1,1,1,check,maps,false);

        if(min==Integer.MAX_VALUE)
        System.out.println(-1);
        else
        System.out.println(min);
        //11 과 nm은 항상 0
        //1은 벽
        //2초
        //11에서 nm까지
        //벽을 한개까지 부셔도 된다.
        //최단 경로
        //n^2* logN까지 가능
    }
    //count, 좌표, check[]
    public static void dfs(int count, int y, int x, int[][] check, int[][] maps, boolean oneCrush){

        Deque<int[]> dq=new LinkedList<>();
        dq.add(new int[]{y,x});
        //bfs로 해야될듯 n*2


        if(y==n && x==m){
            if(min>count)
            min=count;
            return;
        }
        for(int k=0; k<=3; k++){
        int newY=y+dir[k];
        int newX=x+dir[3-k];

        if(1<=newY && newY<=n && 1<=newX && newX<=m){
            if(check[newY][newX]==0 && maps[newY][newX]==0){
            check[newY][newX]=1;
            count++;
            dfs(count,newY,newX,check,maps,oneCrush);
            count--;
            check[newY][newX]=0;
            }
            if(!oneCrush && check[newY][newX]==0 && maps[newY][newX]==1){
                maps[newY][newX]=0;
                check[newY][newX]=1;
                oneCrush=true;
                count++;
                dfs(count,newY,newX,check,maps,oneCrush);
                oneCrush=false;
                maps[newY][newX]=1;
                check[newY][newX]=0;
                count--;
            }
        }
        
        }
        


    }
    
}
