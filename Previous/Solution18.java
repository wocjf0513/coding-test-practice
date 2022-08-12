class Solution18 {
    public static String solution(String new_id) {
    	String answer="";
        answer=new_id.toLowerCase();
        StringBuilder sb=new StringBuilder();
        char pre='0';
        for(char c:answer.toCharArray()) {
        	if(c=='-'||c=='_'||c=='.'||(97<=c&&c<=122)||(48<=c&&c<=57)) {
        		if(c=='.'&&pre=='.') {}
        		else
        			sb.append(c);
        		pre=c;
        	}
        }
        
       if(sb.toString().startsWith(".")) {
    	   sb.deleteCharAt(0);
       }
       if(sb.toString().endsWith(".")) {
    	   sb.deleteCharAt(sb.length()-1);
       }
        
       while(sb.length()>=16) {
    	   sb.deleteCharAt(15);
       }

       if(sb.toString().endsWith(".")) {
    	   sb.deleteCharAt(sb.length()-1);
       }
       if(sb.length()==0) {
    	   sb.append("a");
       }
       while(sb.length()<=2) {
    	   sb.append(sb.charAt(sb.length()-1));
       }
       System.out.print(sb.toString());
        return sb.toString();
    }
    public static void main(String args[]) {
    	solution("...!@BaT#*..y.abcdefghijklm");
    }
}