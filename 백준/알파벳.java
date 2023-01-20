import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 알파벳 {

    static String[] alpa;
    static int[] dir=new int[]{0,0,+1,-1};
    static int y,x;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());

        alpa=new String[y];
        for(int i=0; i<y; i++){
            alpa[i]=br.readLine();
        }

        //대문자 26개 

        int check=1<<(alpa[0].charAt(0)-'A');
        dfs(0,0,1,check);

        System.out.println(max);

    }
    public static void dfs(int ly, int lx, int cnt, int check){

        for(int i=0; i<4; i++){
            int nY=ly+dir[i];
            int nX=lx+dir[3-i];
            if(0<=nY && 0<=nX && nY<y && nX<x){
                int curIdx=1<<(alpa[nY].charAt(nX)-'A');
                if((check&curIdx)!=curIdx){
                    dfs(nY,nX,cnt+1,check|curIdx);
                }
                else{
                    if(max<cnt)
                    max=cnt;
                }
            }
        }
    }
    
}



// Deque<int[]> dq=new ArrayDeque<>();
//         dq.add(new int[]{0,0,1,1<<(alpa[0].charAt(0)-'A')});

//         while(!dq.isEmpty()){
//             int[] temp=dq.poll();
//             int nextCnt=temp[2]+1;
//             int check=temp[3];

//             if(max<nextCnt-1){
//                 max=nextCnt-1;
//             }

//             for(int i=0; i<4; i++){
//                 int nY=dir[i]+temp[0];
//                 int nX=dir[3-i]+temp[1];

//                 if(0<=nY && nY<y && 0<=nX && nX<x){
//                     int cur=1<<(alpa[nY].charAt(nX)-'A');
//                     if((check&cur)==cur){
                        
//                     }
//                     else{
//                         dq.add(new int[]{nY,nX,nextCnt,check|cur});
//                     }
//                 }
//             }
//         }

//         System.out.println(max);