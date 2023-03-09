import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class 팰린드롬분활 {

    static String s;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();
        boolean dp[][]=new boolean[s.length()+1][s.length()+1];
        for(int i=1; i<=s.length(); i++){
            for(int j=i; j<=s.length(); j++){
                if(isPalindrom(i, j)){
                    dp[i][j]=true;
                }
            }
        }
        
        int[] dp2=new int[s.length()+1];

        for(int i=1; i<=s.length(); i++){
            dp2[i]=Integer.MAX_VALUE;
        }

        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=i; j++){
                if(dp[j][i]){
                    dp2[i]=Math.min(dp2[i],dp2[j-1]+1);
                }
            }
        }
		System.out.println(dp2[s.length()]);

    }
    public static boolean isPalindrom(int start, int end){
        start-=1;
        end-=1;
        while(start<=end){
			if(s.charAt(start++) !=s.charAt(end--)){
				return false;
			}
		}

        return true;

    }
    
    
}


//ABAC

//A, B, A, C

//A B A, C