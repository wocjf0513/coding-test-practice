import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 섬의개수 {

    static int direction[]=new int[]{0,0,1,-1,-1,+1,+1,-1};
    static int direction2[]=new int[]{1,-1,0,0,+1,-1,+1,-1};
    static int[][] check;
    static int[][] data;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list=new ArrayList<>();
        StringTokenizer st;

        while(true){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int count=0;

            if(w==0 && h==0)
            break;

            data=new int[h][w];
            check=new int[h][w];

            //데이터 받기
            for(int i=0; i<h; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    data[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            //bfs
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(check[i][j]!=1 && data[i][j]==1){
                    bfs(i,j);
                    count++;
                    }

                }
            }
            list.add(count);
        }

        list.forEach(x->System.out.println(x));
        
    }

    public static void bfs(int x,int y){
        Deque<int[]> deque=new LinkedList<>();
        deque.add(new int[]{x,y});

        while(!deque.isEmpty()){
            
            int temp[]=deque.poll();

            for(int i=0; i<8; i++){
                int temp_x=temp[0]+direction[i];
                int temp_y=temp[1]+direction2[i];

                if(0<=temp_x && temp_x<data.length && 0<=temp_y && temp_y<data[0].length){
                    if(data[temp_x][temp_y]==1 && check[temp_x][temp_y]!=1){
                        check[temp_x][temp_y]=1;
                        deque.add(new int[]{temp_x,temp_y});
                    }
                }


            }
        }


    }
    
}


