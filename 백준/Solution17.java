import java.util.HashMap;

class Solution17 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:participant) {
        	if(map.get(s)==null)
        		map.put(s,1);
        	else
        		map.put(s, 1+map.get(s));
        }
    
    for(String c:completion)
    	map.put(c,map.get(c)-1);
   
    for(String s:map.keySet()) {
    	if(map.get(s)==1)
    		answer+=s;
    }
    return answer;	
    }
    public static void main(String args[]) { 
    	System.out.print(
    	    	solution(new String[] {"mislav", "stanko", "mislav", "ana"},new String[] {"stanko", "ana", "mislav"}));
    }
}

