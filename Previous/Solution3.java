import java.util.*;


class Solution3 {
    public static int solution(int[] citations) {
    	int helper=1;
    	Integer[] toint=Arrays.stream(citations).boxed().toArray(Integer[]::new);
    	ArrayList<Integer> res=new ArrayList<Integer>(Arrays.asList(toint));
        Collections.sort(res,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
        });
        Iterator iter=res.listIterator();
        for(int i=0; i<res.size(); i++) {
        if(iter.hasNext()==true) {
        	if(Integer.parseInt(iter.next().toString())<helper) {
        		return helper-1;
        	}
        	else {
        		helper++;
        	}
        }
        }
        return helper-1;
        
    }
        
    public static void main(String args[]) {
    	solution(new int[] {3,0,6,1,5}); //테스트 케이스 
    	
    }
}