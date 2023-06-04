import java.util.*;
class Solution2 {
    public static String solution(int[] numbers) {
    	String anw="";
        String[] str_num=new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
        str_num[i]=Integer.toString(numbers[i]);
        
        Arrays.sort(str_num);
        
        Arrays.sort(str_num, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int o1o2=Integer.parseInt(o1+o2);
				int o2o1=Integer.parseInt(o2+o1);
				if(o1o2<o2o1) {
					return 1;
				}
				else if(o1o2>o2o1) {
					return -1;
				}
				else
					return 1;
	
			}
        });
        
        for(int i=0; i<numbers.length; i++)
        	anw+=str_num[i];
        
        if(anw.charAt(0)=='0')
        	return "0";
       
            return anw;
        
    }

    public static void main(String args[]) {
    	System.out.print(solution(new int[] {21,212})); //테스트 케이스 입력 
    }
}
    