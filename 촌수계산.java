import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 촌수계산 {
    static int min=Integer.MAX_VALUE;
    static int[][] rel;


    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        rel=new int[n+1][n+1];
        int[][] check=new int[n+1][n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());

        int n2=Integer.parseInt(br.readLine());

        //부모-자식의 관계만 
        for(int i=0; i<n2; i++){
            st=new StringTokenizer(br.readLine());
            int tempX=Integer.parseInt(st.nextToken());
            int tempY=Integer.parseInt(st.nextToken());
            rel[tempY][tempX]=1;  //x는 부모, y는 자식
        }

        dfs(n,x,y,0,check);

        if(min==Integer.MAX_VALUE){
            bw.write("-1");
        }
        else
        bw.write(Integer.toString(min));
        
        bw.close();
        br.close();
        
        
    }
    public static void dfs(int n, int x, int y, int relN, int[][] check){
        if(x==y){
            if(relN<min)
            min=relN;
        }
        for(int i=1; i<=n; i++){
            if(rel[x][i]==1 & check[x][i]==0){
                check[x][i]=1;
                dfs(n, i, y, relN+1, check);
                check[x][i]=0;
            }
            if(rel[i][x]==1 & check[i][x]==0) {
                check[i][x]=1;
                dfs(n, i, y, relN+1, check);
                check[i][x]=0;
            }
        }
    }
}
