import java.util.*;


public class baekjoon_43238 {
    public static void main(String[] args) {
        solution(2, new int[]{1,2});
        
    }
    
    public static long solution(int n, int[] times) {
        long answer = 0;
        long start,mid,end;
        Arrays.sort(times);
        start=1;
        end=(long)n*times[times.length-1];
        //int값을 초과하는 경우 -값을 리턴할 수 있다.
        while(start<end){
            mid=(start+end)/2;
            if(check_time(n, mid, times))
                start=mid+1;
            else
            end=mid;
        }
        answer=end;
        System.out.println(answer);
        return answer;
    }
    public static boolean check_time(int n, long mid, int[] times){
        long count=0;
        for(int t:times)
        count+=mid/t;
        if(count<n)
        return true;
        //mid가 작을 때
        else
        return false;
        //mid가 크거나 같을 때
    }
    //이분법: 근을 포함하는 범위를 정해서 범위를 줄여나가는 과정으로 근을 구하는 방법
    
}
