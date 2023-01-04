import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    static boolean change=true;
    static int[][][] box;

    static int[] dirH={0,0,0,0,+1,-1};
    static int[] dirX={0,0,+1,-1,0,0};
    static int[] dirY={+1,-1,0,0,0,0};

    static int x,y,h;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        x=Integer.parseInt(st.nextToken()); //5
        y=Integer.parseInt(st.nextToken()); //3
        h=Integer.parseInt(st.nextToken()); //1

        box=new int[h+1][y+1][x+1];

        
        for(int i=1; i<=h; i++){
            for(int j=1; j<=y; j++){        
                st=new StringTokenizer(br.readLine());
                for(int k=1; k<=x; k++){
                    box[i][j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }

        int day=-1;
        
    while(change){
        change=false;
        int[][][] check=new int[h+1][y+1][x+1];
        int[][][] newbox=copy(box);

        for(int i=1; i<=h; i++){
            for(int j=1; j<=y; j++){
                for(int k=1; k<=x; k++)
                {
                    if(box[i][j][k]==1 && check[i][j][k]==0){
                        bfs(i,j,k,check,newbox);
                    }
                }
            }
        }
        
        box=copy(newbox);
        day++;
    }

    if(check(box)){
        System.out.println(day);
    }
    else{
        System.out.println(-1);
    }


    }
    public static void bfs(int Lh, int Ly, int Lx, int[][][] check, int[][][] newBox){
        
        Deque<int[]> dq=new LinkedList<>();
        dq.add(new int[]{Lh,Ly,Lx});
        check[Lh][Ly][Lx]=1;

        while(!dq.isEmpty()){
            int temp[]=dq.poll();
            for(int i=0; i<6; i++){
                int newH=temp[0]+dirH[i];
                int newY=temp[1]+dirY[i];
                int newX=temp[2]+dirX[i];

                if(1<=newH && newH<=h && 1<=newY && newY<=y && 1<=newX && newX<=x ){
                    if(box[newH][newY][newX]==0 && check[newH][newY][newX]==0){
                        check[newH][newY][newX]=1;
                        newBox[newH][newY][newX]=1;
                        dq.add(new int[]{newH,newY,newX});
                        change=true;
                    }
                }
            }
            
        }
        

    }
    public static int[][][] copy(int[][][] source){
        int[][][] copyList=new int[h+1][y+1][x+1];

        for(int i=1; i<=h; i++){
            for(int j=1; j<=y; j++){
                for(int k=1; k<=x; k++)
                copyList[i][j][k]=source[i][j][k];
            }
        }
        return copyList;
    }
    public static boolean check(int[][][] box){
        for(int i=1; i<=h; i++){
            for(int j=1; j<=y; j++){
                for(int k=1; k<=x; k++){
                if(box[i][j][k]==-1)
                return false;
                }
            }
        }
        return true;

    }
    
}
