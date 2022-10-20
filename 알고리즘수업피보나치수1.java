import java.util.Scanner;

class 알고리즘수업피보나치수1{
    static int trialA=0;
    static int trialB=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        fibo(input);
        fiboDinamic(input);
        System.out.println(trialA+" "+trialB);
    }
    public static int fibo(int n){
      
        if(n==1 || n==2){
            trialA++;
            return 1;
        }
        else 
        return fibo(n-1)+fibo(n-2);
    }
    public static int fiboDinamic(int n){
        int[] f=new int[n+1];
        f[1]=1;
        f[2]=1;
        for(int i=3; i<=n; i++){
            trialB++;
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
}