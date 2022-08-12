import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1932{

    //마지막 층부터 각자 자신이 갖는 최댓값을 갖게 한다.
    //그러면 마지막 층 위에는 밑에 있는 값 중 최대값을 자신의 값과 더 해 최대값을 갖게 되면 된다.
    //점화식 max[i][j]=Math.max(max[i+1][j],max[i+1][j+1])+data[i][j];
    static int[][] data;
    static int[][] max;

    public static void main(String[] args) throws IOException {

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        int n=Integer.parseInt(s);
        data=new int[n][n];
        max=new int[n][n];
        int i,j;
        int count=0;
        StringTokenizer st;
        for(i=0; i<n; i++){
            s=bf.readLine();
            st=new StringTokenizer(s);
            count++;
            for(j=0; j<count; j++){
                data[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(i=0; i<n; i++){
            max[n-1][i]=data[n-1][i];
        }

        for(i=n-2; i>=0; i--){     
        for(j=0; j<=n-2; j++){
            max[i][j]=Math.max(max[i+1][j],max[i+1][j+1])+data[i][j];            
        }
        }

        System.out.println(max[0][0]);

    }
}