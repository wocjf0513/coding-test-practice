import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 경로찾기{

    static int[][] input_data;
    static ArrayList<Integer> check;
    static int[][] output_data;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int i,j;
        String[] arr;
        input_data=new int[n][n];
        output_data=new int[n][n];
        for(i=0; i<n; i++){
            arr=br.readLine().split(" ");
            for(j=0; j<n; j++){
                input_data[i][j]=Integer.parseInt(arr[j]);
            }
        }

        for(i=0; i<n; i++){
            check=new ArrayList<>();
            dfs(i,i);
        }

        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                System.out.print(output_data[i][j]+" ");
            }
            System.out.println();
        }

        

        //입력 값 받기

    

        

    }
    public static void dfs(int origin, int next){
        for(int i=0; i<input_data.length; i++){
            if(input_data[next][i]==1 && !check.contains(i)){
                check.add(i);
                output_data[origin][i]=1;
                dfs(origin,i);
          
            }
        }
    }
}