import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 증가수열의개수 {



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] nList=new int[n+1];
        int[] preDp=new int[n+1];
        int[] curDp=new int[n+1];
       
        for(int i=1; i<=n; i++){
            nList[i]=sc.nextInt();
            preDp[i]=i;
            curDp[i]=i;
        }

        for(int i=2; i<=k; i++){
            for(int j=0; j<=n; j++){
                if(j<i){
                    curDp[j]=0;
                }
                else{
                curDp[j]=curDp[j-1];
                    for(int l=j-1; l>=i-1; l--){
                        if(nList[l]<nList[j]){
                            curDp[j]+=preDp[l];
                            break;
                        }
                    }
            }
        }
            for(int l=1; l<=n; l++)
            preDp[l]=curDp[l];
        }
                
    
        for(int i:curDp){
            System.out.print(i);
        }
    }
    
}
