import java.util.*;

class Solution6 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge= new LinkedList<>(); //bridge
        int time=0;
        int cor_weight=0;
        int i=0;
        
       while(true)
       {
    	   if(bridge.size()==bridge_length)
    	   {
    		   cor_weight-=bridge.poll();
    	   }
    	   if(truck_weights[i]+cor_weight<=weight)
    	   {
    		   bridge.add(truck_weights[i]);
    		   cor_weight+=truck_weights[i];
    		   if(i==truck_weights.length-1)
    		   {
    			   time+=bridge_length+1;
    			   break;
    		   }
    		   i++;
    	   }
    	   else
    	   {
    		   bridge.add(0);
    	   }

    	   time++;
    	   System.out.print(time);
    	   System.out.println(bridge.peek());

       }
        
        return time;
    }
    public static void main(String args[])
    {
    	System.out.print(solution(2,10,new int[] {7,4,5,6}));
    }
}