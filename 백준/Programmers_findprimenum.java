import java.util.ArrayList;

public class Programmers_findprimenum {

    static String numbers="011";
    static ArrayList<Integer> arr=new ArrayList<Integer>();
    static boolean[] check=new boolean[numbers.length()];
    static int count=0;

    public static void main(String args[]){ 
        //1: 17 -> 1,7,17
        
        String temp="";
 
        for(int i=1; i<=numbers.length(); i++){
        dfs(numbers, temp, i);
        }
        
        for(int i:arr){
            System.out.println(i);
        if(prime(i)) count++;
        }
        //2: prime number
        System.out.println(count);
    }
    public static void dfs(String numbers, String temp, int len){

        if(temp.length()==len){
            if(!arr.contains(Integer.parseInt(temp))) 
            arr.add(Integer.parseInt(temp));
        }
            
        for(int i=0; i<numbers.length(); i++){
            if(!check[i]){
                check[i]=true;
                temp+=numbers.charAt(i);
                dfs(numbers,temp,len);
                check[i]=false;
                temp=temp.substring(0,temp.length()-1);
            }
        }
    }
    public static boolean prime(int n){
        if(n==0 || n==1)
        return false;
        for(int i=2; i<=Math.sqrt(n); i++){
        if(n%i==0)
        return false;
        }
        return true;
    }

    
    
}