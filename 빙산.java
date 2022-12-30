import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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

        int lump=0;
        int year=0;

        //알고리즘 시작
        while(true){
            lump=0;
            int[][] newMap=copy(map);
            int[][] check=new int[y][x];
            for(int i=0; i<y; i++){
                for(int j=0; j<x; j++){
                    if(map[i][j]>=1 && check[i][j]==0)
                    {
                        //bfs 실행
                        bfs(newMap,check,i,j);
                        lump++;
                    }
                }
            }
            if(lump>=2){
                break;
            }
            else{
                year++;
                map=copy(newMap);
            }
        }
        
        System.out.println(year);
    }
    public static int[][] copy(int[][] source){
        int[][] newMap=new int[y][x]; //x ,y 는 전역 변수

        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                newMap[i][j]=source[i][j];
            }
        }
        return newMap;
        
    }
    public static void bfs(int[][] lmap, int[][] check, int ly, int lx){
        Deque<int[]> dq=new LinkedList<>();
        dq.add(new int[]{ly,lx});

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            check[ly][lx]=1;
            for(int i=0; i<4; i++){
                int newY=temp[0]+dir[i];
                int newX=temp[1]+dir[3-i];
                
                if(0<=newY && newY<y && 0<=newX && newX<x){
                    if(map[newY][newX]>=1 && check[newY][newX]==0){
                        dq.add(new int[]{newY,newX});
                    }
                    if(map[newY][newX]==0){
                        if(lmap[temp[0]][temp[1]]>=1)
                        lmap[temp[0]][temp[1]]-=1;
                    }
                }
            }
        }
    }

    //for문으로 돌면서 bfs 찾고 for문 동안
    // bfs가 더 실행되면 이게 덩어리 개수를 의미
    //bfs는 check가 필요하고 좌우상하를 보며 숫자가 없는 곳을 확인
    //두개의 배열이 존재하며, 1은 2를 copy한 상태에서 1을 보며 2의 빙산 상태를
    //변경 for문이 완전히 끝난 상태에서 1에 2를 copy한다.
}
