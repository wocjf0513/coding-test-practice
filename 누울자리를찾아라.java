import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 누울자리를찾아라 {
    static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        matrix=new char[n][n];
        for(int i=0; i<n; i++){
            String readLine=br.readLine();
            for(int j=0; j<n; j++){
                matrix[i][j]=readLine.charAt(j);
            }
        }
        System.out.println(check_site_x(n)+" "+check_site_y(n));
    }
    public static int check_site_x(int n){
        int count=0;
        for(int i=0; i<n; i++){
            String x="";
            for(int j=0; j<n; j++){
                x+=matrix[i][j];
            }
            String[] x_spit=x.split("X");
            for(String s:x_spit)
            if(s.length()>=2)
            count++;

        }
        return count;
        //string 받고 split 나눠서 각 인덱스 길이가 2넘으면 개수 추가
    }
    public static int check_site_y(int n){
        int count=0;
        for(int i=0; i<n; i++){
            String x="";
            for(int j=0; j<n; j++){
                x+=matrix[j][i];
            }
            String[] x_spit=x.split("X");
            for(String s:x_spit)
            if(s.length()>=2)
            count++;

        }
        return count;
        //string 받고 split 나눠서 각 인덱스 길이가 2넘으면 개수 추가
    }
     
}
