import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution12 {
    public static int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
  
        Integer[] answer=new Integer[set.size()];
        set.toArray(answer);
        
        int[] result=new int[set.size()];
       
        int temp=0;
        
        for(Integer i:answer) {
        	result[temp]=i;
        	temp++;
        }
        Arrays.sort(result);
        System.out.print(Arrays.toString(result));
        
        return result;
    }
    public static void main(String args[]) {
    	solution(new int[] {2,1,3,4,1});
    }
}