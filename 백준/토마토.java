import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    
    static int[][][] box;
    static int x,y,h;
    static int[] dirH={0,0,0,0,+1,-1};
    static int[] dirX={0,0,+1,-1,0,0};
    static int[] dirY={+1,-1,0,0,0,0};

    static long ansDay=0;

    

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        x=Integer.parseInt(st.nextToken()); //5
        y=Integer.parseInt(st.nextToken()); //3
        h=Integer.parseInt(st.nextToken()); //1

        box=new int[h+1][y+1][x+1];

        //입력
        for(int i=1; i<=h; i++){
            for(int j=1; j<=y; j++){        
                st=new StringTokenizer(br.readLine());
                for(int k=1; k<=x; k++){
                    box[i][j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        if(ansDay!=0)
        System.out.println(ansDay);
        

    }
        public static void bfs(){
            Deque<int[]> q=new ArrayDeque<>();

            long cnt=h*x*y;
            boolean containsZero=false;
            long wallCnt=0;

            for(int i=1; i<=h; i++){
                for(int j=1; j<=y; j++){        
                    for(int k=1; k<=x; k++){
                        if(box[i][j][k]==1){
                            q.add(new int[]{i,j,k,0});
                        }
                        else if(box[i][j][k]==-1){
                            wallCnt++;
                        }
                        else{
                            containsZero=true;
                        }

                    }
                }
            }

        

            if(!containsZero){
                System.out.println(0);
                return;
            }

            boolean[][][] check=new boolean[h+1][y+1][x+1];

            long tomatoCnt=cnt-wallCnt;
            long tempCnt=0;

            while(!q.isEmpty()){
                int[] temp=q.poll();
                tempCnt++;
                check[temp[0]][temp[1]][temp[2]]=true;
                int day=temp[3];

                if(ansDay<day)
                ansDay=day;

                for(int i=0; i<6; i++){
                    int lh2=temp[0]+dirH[i];
                    int ly2=temp[1]+dirY[i];
                    int lx2=temp[2]+dirX[i];

                    if(lh2>=1 && lh2<=h && ly2>=1 && ly2<=y && lx2>=1 && lx2<=x &&!check[lh2][ly2][lx2]){
                        if(box[lh2][ly2][lx2]==0){
                            //익지 않은 상태                            
                            box[lh2][ly2][lx2]=1;
                            q.add(new int[]{lh2,ly2,lx2,day+1});
                        }        
                    }
                }

            }

            if(tempCnt!=tomatoCnt){
                ansDay=0;
                System.out.println(-1);
                return;
            }



        }
       
    
}
