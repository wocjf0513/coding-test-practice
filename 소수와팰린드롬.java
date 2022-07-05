import java.util.Scanner;

class 소수와팰린드롬{
    
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        
        if(N==1)
        System.out.println(2);
        else{
        while(true){
            //팰린드롬 확인
            if(isPalindrome(N) && isPrime(N)){
            System.out.println(N);
            break;
            }
            N++;
            //소수 확인
        }
    }
        
        sc.close();
        
        System.out.println((System.currentTimeMillis()-start));
    }
    
    public static boolean isPalindrome(int n){
        String str_n=Integer.toString(n);
        int len_str_n=str_n.length();
        for(int i=0; i<len_str_n/2; i++){
            if(str_n.charAt(i)!=str_n.charAt(len_str_n-1-i))
            return false;
        }
        return true;
    }
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
}