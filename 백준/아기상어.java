import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 아기상어 {

    static int maps[][];
    static int min=Integer.MAX_VALUE;
    static int[] dir={0,0,-1,+1};
    static int sharkSize=2;
    static int eatCount=0;
    static boolean movable;

    static int sharkY,sharkX;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        maps=new int[n+1][n+1];

        int sharkY=0,sharkX=0;

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==9)
                {
                    sharkY=i;
                    sharkX=j;
                }
                maps[i][j]=temp;
            }
        }
        //9는 아기상어 위치
        movable=true;
        int time=0;

        while(movable){
            min=Integer.MAX_VALUE;

            bfs(sharkY,sharkX);

            if(sharkSize==eatCount){
                sharkSize++;
                eatCount=0;
            }

            if(min!=Integer.MAX_VALUE){
                time+=min;
            }

            //이동
            

        }
        System.out.println(time);

        
    }
    //작으면 먹을 수 있고, 같으면 이동만 가능하다.
    //자신의 위치로부터 가장 가까운 (상단, 좌측)
    //크기와 같은 마리를 먹을 수록 크기가 1커진다.
    //아기상어의 크기 2
    public static void bfs(int y, int x){
        Deque<int[]> dq=new LinkedList<>();
        dq.add(new int[]{y,x,0});
        int[][] check=new int[maps.length][maps.length];
        ArrayList<int[]> list=new ArrayList<>();
        check[y][x]=1;

        while(!dq.isEmpty()){
            int temp[]=dq.poll();
            int tempTime=temp[2];
            if(tempTime>=min)
            break;

            for(int i=0; i<4; i++){
                int newY=temp[0]+dir[i];
                int newX=temp[1]+dir[3-i];
        

                if(1<=newY && newY<=maps.length-1 && 1<=newX && newX<=maps.length-1){
                    if(maps[newY][newX]<=sharkSize && check[newY][newX]==0){
                        if(maps[newY][newX]==0){
                            check[newY][newX]=1;
                            dq.add(new int[]{newY,newX,1+temp[2]});
                        }
                        else if(maps[newY][newX]==sharkSize){
                            check[newY][newX]=1;
                            dq.add(new int[]{newY,newX,1+temp[2]});
                        }
                        else{
                            //고기 먹기
                            min=temp[2]+1;
                            check[newY][newX]=1;
                            list.add(new int[]{newY,newX,min});
                        }
                    }
                }
                
            }
            list.sort(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]!=o2[0])
                    return o1[0]-o2[0];
                    else{
                        return o1[1]-o2[1];
                    }
                }
                
            });
            if(list.size()>=1){
                movable=true;
                int[] temp2=list.get(0);
                sharkY=temp2[0];
                sharkX=temp2[1];
                eatCount++;

            }
            else{
                movable=false;
            }
        


        }

    }
    
}
