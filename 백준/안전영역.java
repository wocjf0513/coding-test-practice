import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 안전영역 {

    static int[][] input;
    static int[][] check;
    static int count=0;
    static int[][] trans_arr;
    static int[] direction=new int[]{0,0,-1,+1};
    
    public static void main(String[] args) throws IOException {
        //높이에 따라 안전영역의 최대 개수를 센다.
        //물의 높이에 따라 input의 값 변환
        //이 값을 bfs

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int temp=0;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        input=new int[n][n];
        check=new int[n][n];
        for(int i=0; i<n; i++){
            String arr[]=br.readLine().split(" ");
            for(int j=0; j<n; j++){
                temp=Integer.parseInt(arr[j]);
                input[i][j]=temp;
                if(max<temp)
                max=temp;
                if(min>temp)
                min=temp;
            }
        }

        int count_comp=0;
        for(int i=min-1; i<max; i++){
            trans_arr=trans(i);
            check=new int[input.length][input.length];
            count_comp=0;
            
            for(int j=0; j<input.length; j++){
                for(int k=0; k<input.length; k++){
                    if(trans_arr[j][k]==1 && check[j][k]==0){
                    bfs(j,k);
                    count_comp++;
                    }
                }
            }
            if(count<count_comp)
            count=count_comp;

        }

        System.out.println(count);

    
    }
    public static int[][] trans(int height){
        int length=input.length;
        int[][] temp=new int[length][length];
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(input[i][j]>height){
                    temp[i][j]=1;
                }
            }
        }
        return temp;
    }

    public static void bfs(int j,int k){
        Deque<int[]> deque=new ArrayDeque<>();
    
        deque.add(new int[]{j,k});
        check[j][k]=1;

        while(!deque.isEmpty()){
            int[] temp2=deque.poll();
            for(int i=0; i<4; i++){
                int cha_h=temp2[0]+direction[i];
                int cha_w=temp2[1]+direction[3-i]; 

                if(0<=cha_h && cha_h<input.length && 0<=cha_w && cha_w<input.length){
                    if(trans_arr[cha_h][cha_w]==1 && check[cha_h][cha_w]==0){
                        deque.add(new int[]{cha_h,cha_w});
                        check[cha_h][cha_w]=1;
                    }
                }
            }

        }


    }
    
}
