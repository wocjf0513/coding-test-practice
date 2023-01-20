import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산 {

    static int x,y;
    static int map[][];

    static int dir[]={0,0,-1,+1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //좌우 입력
        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());

        map=new int[y][x]; //0부터 시작

        for(int i=0; i<y; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //입력

        int day=0;
        int count=0;

        while(true){
            int[][] check=new int[y][x];
            //카피
            int[][] nMap=new int[y][x];

            copy(nMap,map);

            count=0;
            for(int i=0; i<y; i++){
                for(int j=0; j<x; j++){
                    if(map[i][j]>0 && check[i][j]==0){
                        dfs(nMap,check,i,j);
                        count++;
                    }
                }
            }
            if(count>=2){
                break;
            }
            else if(count==0){
                break;
            }
            else{
                copy(map,nMap);
                day++;
            }

            
        }

        if(count==0)
        System.out.println(0);
        else
        System.out.println(day);



    }
    public static void dfs(int[][] nMap,int[][] check, int ly, int lx){
        check[ly][lx]=1;

        for(int i=0; i<4; i++){
            int ny=ly+dir[i];
            int nx=lx+dir[3-i];
            if(ny>=0 && ny<y && nx>=0 && nx<x && check[ny][nx]==0 && map[ny][nx]>0){
                dfs(nMap,check, ny, nx);
            }
            if(ny>=0 && ny<y && nx>=0 && nx<x && map[ny][nx]<=0){
                nMap[ly][lx]--;
            }

        }
    }
    public static void copy(int[][] sourceM, int[][] goalM){
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                sourceM[i][j]=goalM[i][j];
            }
        }
    }
}

    //for문으로 돌면서 bfs 찾고 for문 동안
    // bfs가 더 실행되면 이게 덩어리 개수를 의미
    //bfs는 check가 필요하고 좌우상하를 보며 숫자가 없는 곳을 확인
    //두개의 배열이 존재하며, 1은 2를 copy한 상태에서 1을 보며 2의 빙산 상태를
    //변경 for문이 완전히 끝난 상태에서 1에 2를 copy한다.
