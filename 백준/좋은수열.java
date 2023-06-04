import java.util.Scanner;

public class 좋은수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        genStr("", n,0);


    }
    public static void genStr(String str, int n, int preN){
        if(str.length()==n){
            System.out.println(str);
            System.exit(0);
            return;
        }
        for(int i=1; i<=3; i++){
            if(preN!=i)
            {
            if(isGood(str+i)){
                genStr(str+i,n,i);
            }
            }
        }
    }
    public static boolean isGood(String str){
        int len=str.length()/2; 
        //까지 좌우로 나눠 확인
        
        for(int i=0; i<str.length(); i++){
            for(int j=1; j<=len; j++){
                if(i+j+j<=str.length()){
                if(str.substring(i, i+j).equals(str.substring(i+j, i+j+j))){
                    return false;
                }
            }
            }
        }
        return true;
    }
   
    
}
