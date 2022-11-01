import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N과M {

    static int n;
    static int m;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        check=new int[n+1];
        StringBuilder sb=new StringBuilder();
        printSeries(sb,0);

    }
    public static void printSeries(StringBuilder sb,int length){
        if(length==m){
            System.out.println(sb.toString());
            return; 
        }
        for(int i=1; i<=n; i++)
        {
            if(check[i]==0){
            sb.append(i+" ");
            check[i]=1;
            length+=1;
            printSeries(sb,length);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            length-=1;
            check[i]=0;
            }
            
        }
        
    }
}
