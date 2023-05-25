import java.util.Scanner;

public class UCPC는무엇의약자일까 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        if(checkUCPC(s))
        System.out.println("I love UCPC");
        else
        System.out.println("I hate UCPC");
        
    }
    public static boolean checkUCPC(String s){
        char[] ucpc=new char[]{'U','C','P','C'};
        int cur=0; 
        for(int i=0; i<4;){
            for(;cur<s.length(); cur++){
                if(ucpc[i]==s.charAt(cur))
                {
                    i++;
                    break;
                }
            }
            if(cur==s.length()){
                return false;
            }
        }
        return true;
    }
    
}
