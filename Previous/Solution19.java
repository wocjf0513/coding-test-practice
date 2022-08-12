import java.util.*;

class Solution19 {
    public static boolean solution(String[] phone_book) {
    	String[] s=phone_book;
    	boolean answer=true;
    	Arrays.sort(s,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
				
			}
    		
    	});
    	
    	for(int i=0; i<s.length; i++) {
    		for(int j=i+1; j<s.length;j++) {
    			if(s[i].startsWith(s[j])==true) {
    				answer=false;
    				break;
    			}
                if(answer==false)
                    break;
    		}
    	}
    	return answer;
    }
    public static void main(String args[]) {
    	solution(new String[] {"119", "97674223", "1195524421"});
    }
}