import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 인구이동 {

    static int count=0;
    static int[][] list;
    static int[] dir={0,0,-1,+1};
    static int N;
    static int L;
    static int R;
    static boolean isChange=false;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        list=new int[N+1][N+1];
        //direction
        int[][] check;

        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                list[i][j]=Integer.parseInt(st.nextToken());
        }

        //값 입력

        //상하좌우 본다음 국경선 열기

        int count=0;

        while(true){
            isChange=false;
            check=new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(check[i][j]==0){
                bfs(check,i,j);
                }
            }
        }
        
        if(isChange)
        count++;
        else
        break;
    }
     System.out.println(count);   


    }
    public static void bfs(int[][] check,int x, int y){
        Deque<int[]> dq=new LinkedList<>();
        ArrayList<int[]> Cop=new ArrayList<>();
        Cop.add(new int[]{y,x});
        dq.add(new int[]{y,x});
        check[y][x]=1;
        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            for(int i=0; i<4; i++){
                int newY=temp[0]+dir[i]; 
                int newX=temp[1]+dir[3-i];
                if(1<=newY && newY<=N && 1<=newX && newX<=N){
                    if(check[newY][newX]==0 && L<=Math.abs(list[temp[0]][temp[1]]-list[newY][newX]) && Math.abs(list[temp[0]][temp[1]]-list[newY][newX])<=R){
                        check[newY][newX]=1;
                        dq.add(new int[]{newY,newX});
                        Cop.add(new int[]{newY,newX});
                    }
                }
            }
        }
        if(Cop.size()>1){
        isChange=true;
        int sum=0;
        for(int[] temp:Cop){
            sum+=list[temp[0]][temp[1]];
        }
        int d=sum/Cop.size();
        for(int[] temp:Cop){
            list[temp[0]][temp[1]]=d;
        }
        }
        //list dir완성
        
    }

}
