import java.util.*;
class Solution4 {
    public static int[] solution(int[] prices) {
        int temp=0;
        int ret=0;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0; i<prices.length;i++){
            temp=prices[i];
            ret=0;
            if(i==prices.length-1) {
                stack.push(ret);
            }
            for(int j=i+1; j<prices.length; j++){
            	ret++;
                if(prices[j]>=temp){
                    if(j==prices.length-1) {
                        stack.push(ret);
                    }
                }
                else{
                	stack.push(ret);
                    break;
                }
            }
        }
        int temp2=prices.length-1;
        int[] answer = new int[prices.length];
        while(!stack.empty()){
            answer[temp2--]=stack.pop().intValue();
        }
        return answer;
    }
    
    public static void main(String args[]) {
    	int[] result=solution(new int[] {1,2,3,2,3});
    	for(int i=0; i<result.length; i++)
    		System.out.print(result[i]);
    }
}