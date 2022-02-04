import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int[][]input;

    static int[] dir=new int[]{0,0,-1,+1};
    static int count=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x,y;
        String arr[]=br.readLine().split(" ");
        x=Integer.parseInt(arr[0]);
        y=Integer.parseInt(arr[1]);

        input=new int[y][x];
        for(int i=0; i<input.length; i++){
            arr=br.readLine().split(" ");
            for(int j=0; j<input[0].length; j++){
                input[i][j]=Integer.parseInt(arr[j]);                
            }
        }

        bfs();
        //0 input
        //1 copy
        //2 check
    
        if(!check_tomatto()){
            System.out.println(-1); 
        }
        else
        System.out.println(count);


    }

    public static void bfs(){
        
        Deque<int[]> deque=new ArrayDeque<>();

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j]==1)
                deque.add(new int[]{i,j,0});    
            }
        }
        //처음 1값 다 넣어주기 

        while(!deque.isEmpty()){
            int[] temp=deque.poll();

        for(int i=0; i<4; i++){
            int tempH=dir[i]+temp[0];
            int tempW=dir[3-i]+temp[1];
            int tempD=temp[2];
            
            if(tempH<0 || input.length<=tempH || tempW<0 || input[0].length<=tempW)
            continue;

            if(input[tempH][tempW]!=0)
            continue;
            
            input[tempH][tempW]=1;
            deque.add(new int[]{tempH,tempW,tempD+1});
        }
        if(deque.isEmpty()){
            count=temp[2];
            break;
        }
    }

 }
    
    public static boolean check_tomatto(){
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j]==0)
                return false;
            }
        }
        return true;
    }


    
}
