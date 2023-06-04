class Solution14
{
    public static long solution(int w, int h) {
    	long answer=0;
    	double function=(double)w/h;
     
    	for(int i=0; i<h; i++) {
      		  answer+=(long)Math.floor(i*function);
      	  }  
        return 2*answer;
      }
    public static void main(String args[]) {
    	System.out.print(
    	solution(8,12));
    }
}