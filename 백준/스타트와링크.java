import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크{

    static int[][] stat;
    static int diff=Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        stat=new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                stat[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(new boolean[n+1], 0, n, 0);

        System.out.println(diff);
    }

    public static void makeTeam(boolean[] member, int preN, int size, int cnt){
        if(cnt==size/2){
            calStat(member);
            return;
        }
        for(int i=preN+1; i<=size; i++){
            member[i]=true;
            preN=i;
            makeTeam(member,preN,size,cnt+1);
            member[i]=false;
        }
    }
    public static void calStat(boolean[] team){
        int stark=0;
        int link=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(team[i] && team[j]){
                    stark+=stat[i][j];
                }
                else if(!team[i] && !team[j]){
                    link+=stat[i][j];
                }
            }
        }

        int localDiff=Math.abs(stark-link);
        if(diff>localDiff){
            diff=localDiff;
        }
    }
    

}