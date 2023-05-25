import java.util.*;

public class Programmers_targetnumber {

    static int answer;
    public static void main (String args[]){
        //int배열의 numbers, int target
         dfs(new int[]{1,1,1,1,1},0,0,3);
         System.out.println(answer);
    }    
    public static void dfs(int[] numbers, int deepth, int sum, int target){
        if(deepth==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        for(int i=0; i<2; i++){
            if(i==1)
                sum+=numbers[deepth];
            else
                sum-=numbers[deepth];
            dfs(numbers,deepth+1,sum,target);
            if(i==1)
                sum-=numbers[deepth];
            else
                sum+=numbers[deepth];
        }

    }
}
