import java.util.*;

class Solution20 {
    public static int solution(String[][] clothes) {
    	HashMap<String,Integer> map=new HashMap<>();
    	
    	for(int i=0; i<clothes.length; i++) {
    		if(map.get(clothes[i][1])==null)
    		map.put(clothes[i][1], 1);
    		else {
    			map.put(clothes[i][1], 1+map.get(clothes[i][1]));
    		}
    	}
    	int answer=1;
    	for(int i:map.values()) {
    		answer*=(i+1);
    	}
    	
    	answer-=1;
    	
    	return answer;
    	
    	
    }
    	
    	
    public static void main(String args[]) {
    	solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}