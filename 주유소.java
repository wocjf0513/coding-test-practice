import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

    static int[] dis_nums;
    static int[] cos_nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] distance=br.readLine().split(" ");
        String[] cost=br.readLine().split(" ");

        dis_nums=Arrays.stream(distance).mapToInt(Integer::parseInt).toArray();
        cos_nums=Arrays.stream(cost).mapToInt(Integer::parseInt).toArray();

        //5 2 4 1
        // 2 3 1
        //첫번쨰 인덱스가 다음 몇번쨰 인덱스꺼까지 작은지 계산
        //그 거리 * cost
        //반복

        int origin=0;
        int next=0;
        long dis_sum=0;
        long cos_sum=0;

        
        while(true){
            if(n-1<=origin)
            break;
            
            next=calculate(origin);
            dis_sum=0;
           
            for(int i=origin; i<next; i++){
                dis_sum+=dis_nums[i];
            }
            cos_sum+=cos_nums[origin]*dis_sum;
            System.out.println(origin+" "+next+" "+cos_sum);
            origin=next;       
        }
        System.out.println(cos_sum);
        

    }

    //시작 인덱스를 주면 다음 몇번째 인덱스가 자기보다 작은지 보여준다.
    //없으면 자신의 인덱스를 준다.
    public static int calculate(int index){
        int answer=cos_nums.length-1;
        for(int i=index+1; i<cos_nums.length; i++){
            if(cos_nums[index]>cos_nums[i]){
                answer=i;
                break;
            }
        }

        return answer;
    }
}