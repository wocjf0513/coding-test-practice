import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 낚시왕 {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Shark>[][] map;
    static int R,C;

    static int[] dirR={-1,1,0,0}; 
    static int[] dirC={0,0,1,-1};


    public static class Shark implements Comparable<Shark>{
        int speed;
        int direction;
        int size;

        Shark(int sp, int d, int si){
            speed=sp;
            direction=d;
            size=si;
        }

        @Override
        public int compareTo(낚시왕.Shark o) {
            return size-o.size;
        }

       

    
    }


    public static void main(String[] args) throws IOException {

        /*조건
        상어가 겹쳤을 때, 가장 큰상어가 나머지 상어를 먹게 된다.
        상어가 벽에 부딪혔을 때, 방향이 반대로 바뀐다.
        방향은 1: 위, 2:아래, 3:오른쪽, 4:왼쪽 이다.
        낚시왕이 이동후, 상어를 잡고 -> 상어가 이동
         */
       
    
        /*입력 */
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken()); int m=Integer.parseInt(st.nextToken());
        map=new PriorityQueue[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j]=new PriorityQueue<>();
            }
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int z=Integer.parseInt(st.nextToken());

            Shark tempShark=new Shark(s, d, z);
            map[r][c].add(tempShark);
        }

        /*알고리즘 */


        /* 낚시꾼 이동 */

        long ans=0;

        for(int j=0; j<C; j++){
            //상어 잡기
            for(int i=0; i<R; i++){
                if(map[i][j].size()>=1){
                    Shark shark=map[i][j].poll();
                    ans+=shark.size;
                    break;
                }
            }

            //상어 이동
            sharkMove();

     

        }
        /*출력 */
        System.out.println(ans);

    }
    public static void sharkMove(){
        //size에따라 체크 나누기
        //상어끼리 먹는 것도 나눠야된다.

        PriorityQueue<Shark>[][] newMap=new PriorityQueue[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                newMap[i][j]=new PriorityQueue<>();
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                for(Shark shark:map[i][j]){
                    //상어 이동
                    //i가 상하
                    //j가 좌우
                    //방향에 따라 상하나 좌우 값이 바뀐다. (방향은 1: 위, 2:아래, 3:오른쪽, 4:왼쪽)
                    int move=shark.speed;
                    int dir=shark.direction;
                    int newR=i;
                    int newC=j;
                 
                    while(move>0){
                        if(dir==1 || dir==2){
                            if((dir==1 && newR==0) || (dir==2 && newR==R-1)){
                                dir=(dir%2)+1;
                            }
                        }
                        else{
                            if((dir==4 && newC==0) || (dir==3 && newC==C-1)){
                                dir=(dir%2)+3;
                            }
                        }
                        newR+=dirR[dir-1];
                        newC+=dirC[dir-1];
                        shark.direction=dir;
                        move--;
                    }

            
                    newMap[newR][newC].add(shark);
                    
                }
            }
        }
        //우선 순위에 따라 상어 대결 (que 사이즈 하나로 만들기)
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                while(newMap[i][j].size()>1){
                    newMap[i][j].poll();
                    
                }
            }
        }
        map=newMap;

    }
    
}
