// You may use import as below.
//import java.util.*;

class Solution1 {
    public long solution(long num) {
        // Write code here.
        num+=1;

        int digit=10;

        int add=0;

        while(num%digit==0){
            add+=digit/10;
            digit*=10;
        }
        num+=add;

        return num;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        long num = 9949999;
        long ret = sol.solution(num);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}