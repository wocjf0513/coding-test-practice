import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {

    static int[][] check;
    static int max=Integer.MIN_VALUE;
    static int[][] forest;
    static int[] dir=new int[]{0,0,-1,+1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        forest=new int[n+1][n+1];
        
        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                forest[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //입력 받음
        check=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                max=Math.max(max,dfs(i,j));
                //한번씩 방문
            }
        }
        System.out.println(max);

    }
    //n번 줄여야 한다...
    //dp사용하자
    public static int dfs(int y, int x){
        if(check[y][x]!=0)
        return check[y][x];

        check[y][x]=1;
        int count=1;

        for(int i=0; i<4; i++){
            int newY=y+dir[i];
            int newX=x+dir[3-i];
            if(1<=newY && newY<=check.length-1 && 1<=newX && newX<=check.length-1){
                if(forest[y][x]<forest[newY][newX])
                {
                    check[y][x]=Math.max(check[y][x],count+dfs(newY,newX));
                }
            }
        }
        return check[y][x];
    }
    //옮긴 지역은 전 지역보다 대나무가 많아야 함.
    //최대한 많은 칸을 방문하게
    // 1<=n<=500
}
