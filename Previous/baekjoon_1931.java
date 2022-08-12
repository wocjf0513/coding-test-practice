import java.util.*;


public class baekjoon_1931 {
 public static void main(String[] args) {
     
    Scanner sc=new Scanner(System.in);
    int i,n=sc.nextInt();
    int[][] time=new int[n+1][2];
    for(i=1; i<=n; i++){
        time[i][0]=sc.nextInt();
        time[i][1]=sc.nextInt();
    }
    Arrays.sort(time, new Comparator<int[]>(){
         @Override 
         public int compare(int[] o1, int[] o2){
             if(o1[1]==o2[1])
                return o1[0] - o2[0]; 
            else
                return o1[1]-o2[1]; 
        }
    });

    int count=0;
    int end_time=0;
    for(i=1; i<=n; i++){
        if(end_time<=time[i][0]){
            count++;
            end_time=time[i][1];
        }
    }
    System.out.println(count);
}

//끝나는 시간이 빠른 대로 정렬
//이제부터 끝나는 시간<= 시작 시간인 걸 count++해준다.
//변수: int[n+1][2];
//greedy algorithm

}
