import java.util.*;
class Solution7 {
    public static int solution(int[] priorities, int location) {
    	Queue<Integer> que=new LinkedList<>();
    	 int[] temp=new int[priorities.length];
    	 Queue<Integer> que2=new LinkedList<>();
    	 
    	 int changebit=0;
    	 int order=1;
    	 
    	 for(int val:priorities)
    		 que.add(val);
    		
    	 
    	 while(true){
    	 temp=que.stream().mapToInt(Integer::intValue).toArray();
    	 
    	 for(int i=0; i<temp.length; i++){
    	 if(temp[0]<temp[i])
    	 {
    		 if(location==0)
    			 location=temp.length;
    		 location--;
    		 que.remove();
    		 que.add(temp[0]);
    		 changebit=0;
    		 break;
    		 
    	 }
    	 else 
    	 {
    		 changebit=1;
    	 }
    	 }
    	 if(changebit==1) {
    		 if(location==0)
    			 break;
    		 else
    		 {
    			 order++;
    			 location--;
    			 que.remove();
    		 }
    			 
    	 }
    	 	}
    	 
    	 return order;
    	
    
    }
    public static void main(String args[]) {
    	System.out.print(solution(new int[] {2,1,3,2},2));
    }
}