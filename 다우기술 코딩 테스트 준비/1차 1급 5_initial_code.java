import java.util.*;

class Solution5 {
    public int[] solution(int N, int[] votes) {
        int voteCounter[] = new int[11]; //1부터 10까지
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1; //후보자의 번호에 ++가 된다.
        }
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i]; 
                cnt = 1;
            }
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }
        int answer[] = new int[cnt];
        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = i;
                idx += 1;
            }
        }
        return answer;
    }
    
    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        int[] ret1 = sol.solution(N1, votes1);
 
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret1) + " .");
        

        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        int[] ret2 = sol.solution(N2, votes2);
 
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + Arrays.toString(ret2) + " .");
    }
}