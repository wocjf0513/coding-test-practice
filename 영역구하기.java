import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 영역구하기 {
    static int input[][];
    static int dir[]={0,0,-1,+1};
    static int check[][];
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y=sc.nextInt();
        int x=sc.nextInt();
        int v=sc.nextInt();

        input=new int[y][x];
        check=new int[y][x];
        int block_n=0;

        for(int i=0; i<v; i++)
        {
            int left_x=sc.nextInt();
            int left_y=sc.nextInt();
            int right_x=sc.nextInt();
            int right_y=sc.nextInt();
            
            for(int j=left_y; j<right_y; j++){
                for(int k=left_x; k<right_x; k++)
                {
                    input[j][k]=1;
                }
            }
        }
        for(int i=0; i<y; i++)
        {
            for(int j=0; j<x; j++)
            {
                if(input[i][j]==0 && check[i][j]==0)
                {
                bfs(i,j,y,x);
                block_n++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(block_n);
        list.forEach(e->System.out.print(e+" "));
        sc.close();
        
    }
    public static void bfs(int y,int x,int lim_y, int lim_x)
    {
        Deque<int[]> deque=new LinkedList<>();
        deque.add(new int[]{y,x});
        check[y][x]=1;
        
        int count=1;
        
        while(!deque.isEmpty())
        {
            int temp[]=deque.poll();

            for(int i=0; i<4; i++)
            {
                int cha_y=dir[i]+temp[0];
                int cha_x=dir[3-i]+temp[1];


                if(0<=cha_y && 0<=cha_x && cha_y<lim_y && cha_x<lim_x)
                {
                    if(check[cha_y][cha_x]==0 && input[cha_y][cha_x]==0)
                    {
                        deque.add(new int[]{cha_y,cha_x});
                        check[cha_y][cha_x]=1;
                        count++;
                    }
                }

            }
        }
        list.add(count);

    }
    
}
