import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 나이트의이동 {

    static int[] dir={2,2,-2,-2,+1,-1,+1,-1};

    static int size=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(t>0){
            size=Integer.parseInt(br.readLine());
            boolean[][] check=new boolean[size][size];
            st=new StringTokenizer(br.readLine());
            int startY=Integer.parseInt(st.nextToken());
            int startX=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int goalY=Integer.parseInt(st.nextToken());
            int goalX=Integer.parseInt(st.nextToken());

            bw.append(bfs(check,startY,startX,goalY,goalX)+"\n");

            t--;
        }
        bw.flush();
        bw.close();
        br.close();

    }
    public static long bfs(boolean check[][],int startY, int startX, int goalY, int goalX){
        check[startY][startX]=true;
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{startY,startX,0});

        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            int nextCnt=temp[2]+1;

            if(temp[0]==goalY && temp[1]==goalX)
            return nextCnt-1;

            for(int i=0; i<8; i++){
                int nY=temp[0]+dir[i];
                int nX=temp[1]+dir[7-i];

                if(0<=nY && 0<=nX && nY<size && nX<size){
                    if(!check[nY][nX]){
                    dq.add(new int[]{nY,nX,nextCnt});
                    check[nY][nX]=true;
                    }
                }
            }


        }

        return 1;


    }
    
}
