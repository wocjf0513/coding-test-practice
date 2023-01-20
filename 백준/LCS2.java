import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class LCS2 {
    
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        try{
        String s1=br.readLine();
        String s2=br.readLine();
        
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        //padding 있음

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }
        //길이 구함.. 탐색

        int len=dp[s1.length()][s2.length()];
        bw.append(len+"\n");

        if(len!=0){
        int x=s2.length(),y=s1.length();
        ArrayList<Character> cList=new ArrayList<>();
        while(len>0){
                if(y==0 || x==0 )
                break;
                if(dp[y][x]==dp[y-1][x]){
                    y=y-1;
                }
                else if(dp[y][x]==dp[y][x-1]){
                x=x-1;
                }
                else{
                    cList.add(s1.charAt(y-1));
                    x=x-1; y=y-1;
                    len--;
                }
         }
          
        for(int i=cList.size()-1; i>=0;  i--){
            bw.append(cList.get(i));
        }
    }

    bw.flush();
    bw.close();
    br.close();
    
        

        }
        //LCS출력
        //이중배열
        //좌측 상단 값만!!
        //오른쪽 값 가져오기!! 
        catch(IOException e){

        }
    }

}
