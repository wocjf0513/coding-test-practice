import java.util.Scanner;

public class baekjoon_1149 {
;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int i, j, n = sc.nextInt(); 
	    int d[][] = new int[n+1][3]; int a[][] = new int[n+1][3];
	    for(i=1;i<=n;i++)
            for(j=0;j<3;j++){
                a[i][j] = sc.nextInt();
            }

        for(i=1; i<=n; i++){
        
            d[i][0]=Math.min(d[i-1][1],d[i-1][2])+a[i][0];
            d[i][1]=Math.min(d[i-1][0],d[i-1][2])+a[i][1];
            d[i][2]=Math.min(d[i-1][0],d[i-1][1])+a[i][2];
        
        }
        
        int min=1000*1000;

        for(int cost:d[n]){
            if(cost<min)
            min=cost;
        }
        System.out.println(min);

    }

    //결국 최소값은 각 단계에서 RGB
    //세 단계를 고려하고 그 전 단계의 최솟값과 더 한 값이된다.
}
