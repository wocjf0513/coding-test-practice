import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 펠린드롬 {
    static int[] nList;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        nList=new int[n+1];
        for(int i=1; i<=n; i++)
        nList[i]=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        
        for(int i=1; i<=m; i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            if(palindrome(s,e))
            bw.write(1+"\n");
            else
            bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
       }
    public static boolean palindrome(int start, int end){

        int len=end-start+1;

        for(int i=0; i<len/2; i++){
            if(nList[start+i]!=nList[end-i]){
                return false;
            }
        }

        return true;

    }
    //팰린드롬 1 : 0
    
}
