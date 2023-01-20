import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

class matrix{
    int n;
    int m;

    matrix(int n, int m){
        this.n=n;
        this.m=m;
    }
}

public class 행렬곱셈순서 {

    static int n;

   
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

     
        int calC=Integer.MAX_VALUE;

       

        matrix[] mList=new matrix[n+1];


        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int input1=Integer.parseInt(st.nextToken());
            int input2=Integer.parseInt(st.nextToken());
            mList[i]=new matrix(input1,input2); 
   
        }
        System.out.println(calDp(mList));


        //(이전 n) x (이전 m) x (이후 m)
        //(이전 n 이후 m)
        //앞뒤로 연산할 수 있다.



        
    }
    public static int calDp(matrix[] mList){
        int dp[][]=new int[n+1][n+1];

       
        
        for(int i=1; i<n; i++){
            dp[i][i+1]=mList[i].n*mList[i].m*mList[i+1].m;
        }

        for(int gap=2; gap<=n; gap++){
            for(int i=1; i+gap<=n; i++){
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i; k<j; k++)
                dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+mList[i].n*mList[k].m*mList[j].m);
            }
        }

        return dp[1][n];



    }
    
    
}
