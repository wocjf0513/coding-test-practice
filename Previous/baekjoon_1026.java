import java.util.*;

public class baekjoon_1026 {

    //결국 a는 오름차순 , b는 내림차순으로 정렬한다음 곱해주면 된다.
    //int primitive 형이기 때문에 for문을 돌려서 내림차순 정렬해줄 수 도 있고
    //integer로 바꿔서 가능하다.
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i,n=in.nextInt();

        int a[]=new int[n]; int b[]=new int[n];
        for(i=0; i<n; i++)
        a[i]=in.nextInt();
        for(i=0; i<n; i++)
        b[i]=in.nextInt();

        Arrays.sort(a);
        Integer[] b_int=Arrays.stream(b).boxed().toArray(Integer[]::new);
        Arrays.sort(b_int, Comparator.reverseOrder());
        b=Arrays.stream(b_int).mapToInt(j->j).toArray();

        int cost=0;
        for(i=0; i<n; i++){
            cost+=a[i]*b[i];
        }
        System.out.println(cost);
    }
    
}
