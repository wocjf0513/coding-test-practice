import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집{

    static int r,c;
	static char[][] map;
	static int[] dr= {-1,0,1};
    static int ans=0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map =new char[r+1][c+1];
		
		for(int i=1; i<=r; i++) {
			String temp = br.readLine();
			for(int j=1; j<=c; j++) {
				map[i][j] = temp.charAt(j-1);
			}
		}
		for(int i=1; i<=r; i++) {
			if(dfs(i,1))
            ans++;
		}
		System.out.println(ans);
	}
    static boolean dfs(int y, int x) {

        if(x==c)
        return true;
	
		for(int i=0; i<3; i++) {
			int nx = x + 1;
			int ny = y + dr[i];
				
            if(1<=nx && nx<=c && 1<=ny && ny<=r){
                if(map[ny][nx]=='.'){
                    map[ny][nx]='x';
                    if(dfs(ny,nx))
                    return true;
                }
            }
	    }

        return false;
    }
}