import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
    static int min=Integer.MAX_VALUE;
    static int y;
    static int x;
    static int[] dir=new int[]{0,0,-1,+1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());

        boolean[][]maps=new boolean[y+1][x+1];

        for(int i=1; i<=y; i++){
            String temp=br.readLine();
            for(int j=1; j<=x; j++){
                if(temp.charAt(j-1)=='1'){
                    maps[i][j]=true;
                }
            }
        }

        System.out.println(bfs(maps));
        
    }

    

    // n^3 = 1.000.000.000

    public static int bfs(boolean[][] map){
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{1,1,1,0});
        //y, x, cnt, 방문했는지
        boolean[][][] check=new boolean[map.length][map[0].length][2];

        check[1][1][0]=true;

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            int cnt=temp[2];
            int destroyed=temp[3];

            if(temp[0]==y && temp[1]==x)
            {
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int ny=temp[0]+dir[i];
                int nx=temp[1]+dir[3-i];

                if(1<=ny && 1<=nx && ny<=y && nx<=x && !check[ny][nx][0]){
                    if(map[ny][nx]==false){ 
                        if(destroyed==0 && !check[ny][nx][0]) {
                            dq.add(new int[]{ny,nx,cnt+1,destroyed});
                            check[ny][nx][0] = true;
                        }else if(destroyed==1 && !check[ny][nx][1]){ 
                            dq.add(new int[]{ny,nx,cnt+1,destroyed});
                            check[ny][nx][1] = true;
                        }
    
                    }else{ 
                        if(destroyed==0){ 
                            dq.add(new int[]{ny,nx,cnt+1,1});
                            check[ny][nx][1] = true;
                        }

                    }
            }

        }

    }
    return -1;
}
}
