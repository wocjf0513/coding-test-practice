import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 행렬 {

    static int[] dir=new int[]{0,1,2,0,1,2,0,1,2};
    static int[] dir2=new int[]{0,0,0,1,1,1,2,2,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] list=new int[n][m];
        int[][] list2=new int[n][m];

        for(int i=0; i<n; i++){
            String temp=br.readLine();
        for(int j=0; j<m; j++)
            list[i][j]=temp.charAt(j)-'0';
        }

        for(int i=0; i<n; i++){
            String temp=br.readLine();
        for(int j=0; j<m; j++)
            list2[i][j]=temp.charAt(j)-'0';
        }


        int count=0;

        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if(list[i][j]!=list2[i][j])
                {
                    count++;
                    for(int k=0; k<9; k++){
                        if(list[i+dir2[k]][j+dir[k]]==0)
                        list[i+dir2[k]][j+dir[k]]=1;
                        else
                        list[i+dir2[k]][j+dir[k]]=0;
                    }
                }
            }
        }

        boolean exbit=true;

        for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(list[i][j]!=list2[i][j]){
            exbit=false;
            break;
            }
        }
        if(!exbit)
        break;
    }

    if(exbit)
    System.out.println(count);
    else
    System.out.println(-1);
        

    }
    public static void show(int[][] list){
        for(int[] i:list){
            for(int n:i){
                System.out.print(n);
            }
            System.out.println();
        }
    }

    //3x3크기의 행렬
    
}
