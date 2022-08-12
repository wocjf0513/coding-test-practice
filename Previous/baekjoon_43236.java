import java.util.*;

public class baekjoon_43236 {
    static int answer=0;
    public static void main(String[] args) {
        solution(25,new int[]{2,14,11,21,17},2);
    }
    public static int  solution(int distance, int[] rocks, int n) {
        int start,mid,end;
        start=1;
        end=distance;
        
        //mid가 기준이 되어 돌을 삭제한다. 돌이 n보다 많이 삭제되거나 적게 삭제 되면 mid를 조정한다.
        Arrays.sort(rocks);

        while(start<end){
            mid=(start+end)/2;
            //돌을 삭제한다.
            if(delete_rock(distance, mid, n, rocks))
                start=mid+1;
            else
                end=mid;
        }
        System.out.println(answer);
        return answer;
    }
    public static boolean delete_rock(int distance, int mid, int n, int[] rocks){
        int remove=0;
        int dis_start=0;
        for(int r:rocks){
            if(r-dis_start<mid)
                remove++;
            else
                dis_start=r;
        }
        if(distance-dis_start<mid)
        remove++;

        if(remove<=n){
        answer=Math.max(mid,answer);
        return true;
        }
        else
        return false;
        

    }

    //거리의 최댓값을 첫바위와 마지막 바위의 거리로 설정
    //거리의 최소값은 1로 설정한다.
    //distance가 최대 1.000.000.000이므로 int실수를 최소화한다.

    
}
