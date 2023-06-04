import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 아기상어 {

    static int moveY[]={-1,0,0,+1};
    static int moveX[]={0,-1,1,0};
    static int n;
    static int sharkSize=2;
    static int[][] maps;
    static int realTime=0;
    static int eatCount=0;


    static int sharkY,sharkX;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        maps=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                maps[i][j]=Integer.parseInt(st.nextToken());

                if(maps[i][j]==9){
                    sharkY=i;
                    sharkX=j;
                }
            }
        }

        while(true){
          
            int temp[]=bfs(sharkY,sharkX);
            if(temp[2]==0){
                break;
            }
            else{
                sharkY=temp[0];
                sharkX=temp[1];
                if(sharkSize==eatCount){
                    sharkSize++;
                    eatCount=0;
                }
            }
        }

        System.out.println(realTime);



    }
    public static int[] bfs(int y, int x){

        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{y,x,0});

        int minY=Integer.MAX_VALUE,minX=Integer.MAX_VALUE;
        int minTime=Integer.MAX_VALUE;
        maps[y][x]=0;

        boolean[][] check=new boolean[n+1][n+1];
        
        check[y][x]=true;

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            int time=temp[2]+1;

            for(int i=0; i<4; i++){
                int newY=temp[0]+moveY[i];
                int newX=temp[1]+moveX[i];

                if(1<=newY && newY<=n && 1<=newX && newX<=n){
                    if(minTime<time){
                    eatCount++;
                    realTime+=minTime;
                    return new int[]{minY,minX,minTime};
                    }
                    if(!check[newY][newX]){
                        if(maps[newY][newX]<sharkSize && maps[newY][newX]!=0 && time<=minTime && (newY<minY ||((newY==minY) && (newX<minX))) ){
                            minY=newY;
                            minX=newX;
                            minTime=time;
                        }
                        else if(maps[newY][newX]==0 || maps[newY][newX]==sharkSize){
                            dq.add(new int[]{newY,newX,time});
                            check[newY][newX]=true;
                        }
                        else{
                            check[newY][newX]=true;
                        }
                    }
                    
                }
            }
        }
        if(minTime!=Integer.MAX_VALUE){
        eatCount++;
        realTime+=minTime;
        return new int[]{minY,minX,minTime};
        }
        else
        return new int[]{0,0,0};

    }
    //0 빈칸 9 아기 상어 :처음 크기 2
}
