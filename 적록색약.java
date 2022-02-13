import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static int[][] check;
    static int count[]=new int[2];
    static char[][] input;
    static int[] direction=new int[]{0,0,-1,+1};

    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        input=new char[n][n];
        check=new int[n][n];

        for(int i=0; i<n; i++)
        input[i]=br.readLine().toCharArray();
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            if(check[i][j]!=1){
            bfs(i,j);
            count[0]++;
            }
        }

        check=new int[n][n];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            if(input[i][j]=='G')
            input[i][j]='R';
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            if(check[i][j]!=1){
            bfs(i,j);
            count[1]++;
            }
        }

        System.out.println(count[0]+" "+count[1]);
        
    }
    public static void bfs(int i, int j)
    {
        Deque<int[]> deque=new LinkedList<>();
        deque.add(new int[]{i,j});
        
        while(!deque.isEmpty())
        {
            int temp[]=deque.poll();
            char c=input[temp[0]][temp[1]];

            for(int tmp=0; tmp<4; tmp++)
            {
            int ch_h=temp[0]+direction[tmp];
            int ch_w=temp[1]+direction[3-tmp];

            if(ch_h<0 || ch_w<0 || input.length<=ch_h || input.length<=ch_w)
            continue;
            
            if(c==input[ch_h][ch_w] && check[ch_h][ch_w]!=1)
            {
                deque.add(new int[]{ch_h,ch_w});
                check[ch_h][ch_w]=1;
            }

            }
        }
    }
    
}
