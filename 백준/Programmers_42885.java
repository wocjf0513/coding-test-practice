import java.util.*;

public class Programmers_42885 {
    public static void main(String[] args) {
        solution(new int[]{70,80,50},100);
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int start=0;
        int end=people.length-1;

        Arrays.sort(people);
        //50 50 70 80 
        //50 70 80
        // 0 2
        // 0 1
        while(start<=end){
            if(people[end]+people[start]<=limit){
                start++;
                end--;
            }
            else{
                end--;
            }
            answer++;
            
            System.out.println(answer);
        }
        return answer;
    }
    
}
