import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안녕 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int health[]=new int[n+1];
        int joy[]=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            health[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            joy[i]=Integer.parseInt(st.nextToken());
        }

        //입력 받고
        int sourceDp[]=new int[100];
        int copyDp[];

        for(int i=1; i<=n; i++){
            int h=health[i];
            int j=joy[i];
            copyDp=new int[100];

            for(int k=0; k<=99; k++){
                if(sourceDp[k]!=0){
                    if(k+h<=99){
                        //이전 값이 있는 경우
                    copyDp[k+h]=Math.max(sourceDp[k]+j,sourceDp[k+h]);
                    }
                }
            }
            for(int k=0; k<=99; k++){
                if(copyDp[k]!=0)
                sourceDp[k]=copyDp[k];
            }
            
            if(h<=99)
            sourceDp[h]=Math.max(sourceDp[h],j);
        }

        int max=Arrays.stream(sourceDp).max().getAsInt();
        
        System.out.println(max);


    }
    
}
