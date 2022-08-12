import java.util.*;

public class baekjoon_11053{

    // data[3] 을 예로 자기보다 작은 인덱스 0,1,2의 data값을 보고 자기보다 작은 것들을 찾아
    // 그 중 가장 length가 높은 걸 찾아 +1 한 값을 자기의 length값으로 쓴다.
    // 점화식은 : length[3]= max(length[0], length[1], length[2]) (data[0],data[1],data[2]가 data[3]보다 작다는 가정하에) 

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i,n=in.nextInt();
        int[] data=new int[n]; int[] length=new int[n];
        for(i=0; i<n; i++){
            data[i]=in.nextInt();
            length[i]=1;
        }        

        int max_length=0;

        for(i=0; i<n; i++){
            max_length=0;
            for(int j=0; j<i; j++){
                if(data[i]>data[j])
                if(max_length<length[j])
                max_length=length[j];
            }
            length[i]=max_length+1;
        }

        max_length=0;

        for (int j : length) {
            if(max_length<j)
            max_length=j;
        }
        System.out.println(max_length);
    }


}