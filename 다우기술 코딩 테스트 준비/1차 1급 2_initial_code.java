import java.util.ArrayList;

// You may use import as below.
//import java.util.*;

class Solution2 {
    public int solution(int n) {
        // Write code here.
        ArrayList<Integer> list=new ArrayList<>();

        if(n==0)
        return 0;

        else{

            list.add(1);
            int count=0;
            int temp=n-1;
            int sum=1;
            while(list.size()<n)
            {
                int pre=list.get(list.size()-1);
                pre=pre+temp*2;
                list.add(pre);
                count++;

                if(count%2==0)
                {
                    temp-=2;
                }

                sum+=pre;
                

            }

            return sum;
        }
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n1 = 5;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        

    }
}