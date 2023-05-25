import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 인구이동{

    static int dir[]=new int[]{0,0,-1,+1};
    static int population[][];
    static int N,L,R;
    static boolean isChanged=true;
    static int sum=0;

    static ArrayList<int[]> list;

    static boolean check[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());

        population=new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                population[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int day=0;

        while(isChanged){
            isChanged=false;
            check=new boolean[N+1][N+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(!check[i][j]){
                        list=new ArrayList<>();
                        sum=0;
                        dfs(i,j);
                        for(int k=0; k<list.size(); k++){
                            int temp[]=list.get(k);
                            population[temp[0]][temp[1]]=(int)(sum/list.size());
                        }
                    }
                }
            }

            if(!isChanged)
            break;
            
            day++;

        }
        System.out.println(day);

    }
    public static void dfs(int y, int x){
        check[y][x]=true;
        sum+=population[y][x];
        list.add(new int[]{y,x});
        for(int i=0; i<4; i++){
            int newY=y+dir[i];
            int newX=x+dir[3-i];
            if(1<=newY && newY<=N && 1<=newX && newX<=N && !check[newY][newX]){
                int diff=Math.abs(population[y][x]-population[newY][newX]);
                if(L<=diff && diff<=R){
                isChanged=true;
                dfs(newY,newX);
                }
            }
        }
    }
}