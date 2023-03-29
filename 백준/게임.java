import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임 {

    static int max=0;

    static char[][] board;

    static int[][] dp;

    static int[] dir=new int[]{0,0,-1,+1};

    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new char[N+1][M+1];
        dp=new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            String temp=br.readLine();
            for(int j=1; j<=M; j++){
                board[i][j]=temp.charAt(j-1);
            }
        }
        
       dp[1][1]=1;
       dfs(new boolean[N+1][M+1], 1, 1,1);
       System.out.println(max);

        //무한번 움직일 수 있으면, -1 출력
        //왔던 곳을 온다는 건 무한번 움직인다는 것!!
        
    }
    public static void dfs(boolean[][] check, int move, int y, int x){

        if(max==-1)
        {
            return;
        }

        if(max<move){
            max=move;
        }


        for(int i=0; i<=3; i++){
            int newY=y+dir[i]*(board[y][x]-'0');
            int newX=x+dir[3-i]*(board[y][x]-'0');

            if(1<=newY && 1<=newX && newY<=N && newX<=M){
                if(!check[newY][newX] && board[newY][newX]!='H'){
                    check[newY][newX]=true;
                    if(dp[newY][newX]<move+1){
                        dp[newY][newX]=move+1;
                        dfs(check,move+1,newY,newX);
                    }
                    else{

                    }
                    check[newY][newX]=false;
                }
                else if(board[newY][newX]=='H'){
                    
                }
                else{
                    max=-1;
                }

            }
        }
        
    }
    
}
