import java.util.*;
class Solution1 {
    public String solution(int[] numbers, int[][]commands) {
    	String anw="";
        String[] str_num=new String[numbers.length];
        for(int i=0; i<numbers.length; i++)
        str_num[i]=Integer.toString(numbers[i]);
        Arrays.sort(str_num, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(numbers.length==0)
					return 0;
				else {
					int len=o1.length()-o2.length();
					if(len>=0) {
						len=o2.length();
					}
				for(int i=0; i<len; i++)
				if(o1.charAt(i)==o2.charAt(i)) {
					i++;
					if(i==len-1) {
						//33 334°ú °°Àº »ç·Ê
						return 1;
					}
				}
				else {
					return o2.charAt(i)-o1.charAt(i);
				}
			}
				return 1;
			}
        });
        
        for(int i=0; i<numbers.length; i++)
        	anw+=str_num[i];
        return anw;
        
    }
}