import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class 보물섬{
    
    static char[][] map;
    static int y,x;
    static int dir[]={0,0,-1,+1};

    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());

        String temp;

        map=new char[y+1][x+1];

        for(int i=1; i<=y; i++){
            temp=br.readLine();
            for(int j=1; j<=x; j++){
                map[i][j]=temp.charAt(j-1);
            }
        }

        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                if(map[i][j]=='L')
                bfs(i,j);
            }
        }

        System.out.println(max);

    }
    static void bfs(int ly, int lx){
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{ly,lx,0});

        int time=0;
        
        boolean[][] check=new boolean[y+1][x+1];
        check[ly][lx]=true;

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            time=temp[2];
            
            for(int i=0; i<4; i++){
                int newY=temp[0]+dir[i];
                int newX=temp[1]+dir[3-i];

                if(1<=newY && 1<=newX && newY<=y && newX<=x){
                    if(map[newY][newX]=='L' && !check[newY][newX]){
                        dq.add(new int[]{newY,newX,time+1});
                        check[newY][newX]=true;
                    }
                }
            }
        }

        if(time>max){
            max=time;
        }

    }

}