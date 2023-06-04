// You may use import as below.
//import java.util.*;

class Solution3 {

    int[][] dir=new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},
    {1,2},{-1,2},{1,-2},{-1,-2}};
    
    public int solution(String pos) {
        // Write code here.
        //8칸씩
        int y=pos.charAt(0)-'A'; //A부터 H까지
        int x=pos.charAt(1)-'1'; //1부터 8까지

        //0부터 7까지 허용

        int answer = 0;
        for(int i=0; i<8; i++){
            int tempY=y+dir[i][0];
            int tempX=x+dir[i][1];

            if(0<=tempY && tempY<=7 && 0<=tempX && tempX<=7 )
            answer++;
        }

        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        String pos = "A7";
        int ret = sol.solution(pos);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}