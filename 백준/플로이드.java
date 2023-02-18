import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 플로이드 {

    static int[][] bus;
    static int min=Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        StringTokenizer st;
        bus=new int[n+1][n+1];



        for(int i=1; i<=m; i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            if(bus[start][end]==0)
            bus[start][end]=cost;
            else{
                bus[start][end]=Math.min(bus[start][end],cost);
            }
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                if(bus[i][k]!=0 && bus[k][j]!=0){
                    if(bus[i][j]!=0)
                    bus[i][j]=Math.min(bus[i][j],bus[i][k]+bus[k][j]);
                    else
                    bus[i][j]=bus[i][k]+bus[k][j];
                }  
                }           
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j)
                bw.append(bus[i][j]+" ");
                else
                bw.append(0+" ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
