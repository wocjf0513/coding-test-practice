
class Sol_124 {
    public static String solution(int n) {
    	
        StringBuilder s = new StringBuilder();
        
        int val=0;
        int rest = 0;
        while(0 < n) {
            rest= n%3;

            if(0 == rest) {
                n = n/3 -1;
                rest= 4;
            }else n /= 3;

            val= rest + val;
            s.append(rest);
        }

        return s.reverse().toString();
    }
    public static void main(String args[]) {
    	System.out.print(solution(513));
    }
}