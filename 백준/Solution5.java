import java.util.*;
class Solution5 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int len=progresses.length;
        int[] period=new int[len];
        for(int i=0; i<len; i++)
        {
            period[i]=(int)Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
        
        Stack<Integer>stack=new Stack<>();
        
        int temp;
        int res;
        
        for(int i=0; i<len; i++)
        {
        	temp=period[i];
        	res=1;
        	
        	for(int j=i+1; j<len; j++)
        	{
        	if(temp>=period[j])
        	{
        		res++;
        		if(j==len-1)
        		{
        			stack.push(res);
        			i=len;
        			break;
        		}
        			
        	}
        	else 
        	{
        		stack.push(res);
        		i=j-1;
        		if(j==len-1)
        			stack.push(1);
        		break;
        		
        	}
        }
        
    }
        int[] answer=new int[stack.size()];
        int i=stack.size()-1;
        while(!stack.empty()) {
        	answer[i]=stack.pop();
        	i--;
        }
        
        return answer;
    }
    public static void main(String args[]) {
    	int res[]=solution(new int[] {96, 99, 98, 97},new int[] {1,1,1,1});
    	int i=0;
    	System.out.println();
    	while(i<res.length)
    	{
    		System.out.print(res[i]);
    		i++;
    	}
    }
    
}