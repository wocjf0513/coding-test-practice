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
    static int maxT=Integer.MIN_VALUE;
    static int maxL;
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
        //L이면 1, W면 0
        //둘 사이의 최단 거리
        
        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                if(map[i][j]=='L'){
                boolean check[][]=new boolean[y+1][x+1];
                bfs(check,i,j);
                }
            }
        }

        System.out.println(maxT);


    }
    static void bfs(boolean[][] check, int ly, int lx){
        check[ly][lx]=true;
        Deque<int[]> dq=new ArrayDeque<>(y*x);
        dq.add(new int[]{ly,lx,0});

        int temp[];
        int Y;
        int X;
        int T;

        while(!dq.isEmpty()){
            temp=dq.poll();
            check[temp[0]][temp[1]]=true;


            if(maxT<temp[2])
            maxT=temp[2];
            
            for(int i=0; i<4; i++){
                Y=temp[0]+dir[i];
                X=temp[1]+dir[3-i];
                T=1+temp[2];

                if(1<=Y && Y<=y && 1<=X && X<=x){
                    if(check[Y][X]==false && map[Y][X]=='L')
                        dq.add(new int[]{Y,X,T});
                }
            }

        }
    }

}