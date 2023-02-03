import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {

    static int[][] map;
    static int n;
    static boolean isArrived=true;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());

        map=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st=new StringTokenizer(br.readLine());

        int start=0;

        for(int i=1; i<=k; i++){
            int city=Integer.parseInt(st.nextToken());

            if(i==1)
            {
                start=city;
            }
            else{
                isArrived=false;
                dfs(start,city,new boolean[n+1]);
                if(isArrived==false){
                    break;
                }
                start=city;
            }
        }
        if(isArrived)
        System.out.println("YES");
        else
        System.out.println("NO");
    }
    public static void dfs(int start, int goal, boolean[] check){
        check[start]=true;

        if(start==goal){
        isArrived=true;
        return;
        }

        for(int i=1; i<=n; i++){
            if(map[start][i]==1 && !check[i]){
                dfs(i,goal, check);
            }
        }
    }

    
}
