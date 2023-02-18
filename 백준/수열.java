import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수열 {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] nList=new int[n+1];
        int[] dpMax=new int[n+1];
        int[] dpMin=new int[n+1];

        for(int i=1; i<=n; i++){
            nList[i]=Integer.parseInt(st.nextToken());
        }

        int max=0;
        int min=0;

        for(int i=1; i<=n; i++){
            if(nList[i-1]<=nList[i]){
                dpMax[i]=dpMax[i-1]+1;
            }
            else{
                dpMax[i]=1;
            }

            if(nList[i-1]>=nList[i]){
                dpMin[i]=dpMin[i-1]+1;
            }
            else{
                dpMin[i]=1;
            }

            if(dpMin[i]>min){
                min=dpMin[i];
            }

            if(dpMax[i]>max){
                max=dpMax[i];
            }
            
        }

        System.out.println(Math.max(max,min));
    }

}
