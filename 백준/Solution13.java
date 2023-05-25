import java.util.*;

class Solution13 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
       

        int col=board[0].length;
        int row=board.length;
        
        List<Stack<Integer>> stack=new ArrayList<Stack<Integer>>(row);
        
        for(int i=0; i<row; i++)
        stack.add(new Stack<Integer>());
     
        for(int i=0; i<row; i++)
        	for(int j=col-1; j>=0; j--) {
        		stack.get(i).push(board[j][i]);
        	}
        
        
       int temp=0;
       int val=0;
        
       Stack<Integer> basket=new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++) {
        	val=0;
        	temp=moves[i]-1;
        	while(true) {
        		
        		while(val==0 && !stack.get(temp).isEmpty())
            		val=stack.get(temp).pop();

        		if(val==0)
        			break;
        		
        		
        		if(!basket.isEmpty()) {
        			if(basket.peek()==val)
        			{
        			basket.pop();
        			answer+=2;
        			}
        			else
        				basket.push(val);
        		}
        		else
        			basket.push(val);
        		

    			System.out.print(val);
        		break;
        	}
        	
            System.out.println(answer);
        }
        return answer;
    }
    public static void main(String args[]) {
    	solution(new int[][] {{0,2,0},{1,2,0},{2,2,1}},new int[] {1,2,2,2,1,3});
    }
}