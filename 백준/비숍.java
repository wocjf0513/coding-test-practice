import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 비숍 {
    /*서로가 서로를 잡을 수 없는 위치에 놓을 수 있는 비숍의 최대 개수 */

    static int n;
    static boolean[][] placable;
    static int maxN=0;

    public static void main(String[] args) throws IOException {
        /* 입력 */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());


        placable=new boolean[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    placable[i][j]=true;
                }
            }
        }
        /* 체스판의 크기 10이하 */
        /* 시간 제한 10초 => 100억*/
        int ans=0;
        dfs(new boolean[n][n],0, 0, true);
        ans=maxN;
        maxN=0;
        dfs(new boolean[n][n],0, 0, false);
        ans+=maxN;

        System.out.println(ans);

        /* 알고리즘 */
    }
    public static void dfs(boolean[][] temp,int idx, int count, boolean black){
          
        if(count>maxN){
        maxN=count;
        }

        for(int i=idx; i<n*n; i++){
            int y=i/n;
            int x=i%n;
            if(placable[y][x]){
            if(black){
                if((y+x)%2==1 && isAvailable(temp, y, x)){
                temp[y][x]=true;
                dfs(temp,i+1,count+1,true);
                temp[y][x]=false;

                }
            }
            else{
                if((y+x)%2==0 && isAvailable(temp, y, x) ){
                temp[y][x]=true;
                dfs(temp,i+1,count+1,false);
                temp[y][x]=false;
                }
            }
        }
            
        }

    }
   
    public static boolean isAvailable(boolean[][] map, int y, int x){
 
        //대각선인거만 보는걸로 
        //왼쪽 위 대각선 
        for(int i=0; i<y; i++){
            int diff=i-y;
            int newX=diff+x;

            if(0<=newX && newX<n){
                if(map[i][newX]){
                    return false;
                }
            }
        }

        //오른쪽 위 대각선

        for(int i=0; i<y; i++){
            int diff=y-i;
            int newX=diff+x;

            if(0<=newX && newX<n){
                if(map[i][newX]){
                    return false;
                }
            }
        }

        return true;
    }
    
}
