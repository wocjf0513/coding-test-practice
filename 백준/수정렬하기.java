import java.util.*;
public class 수정렬하기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        final int count=n;
        int[] list=new int[n];
        while(n!=0){
            list[count-n]=sc.nextInt();
            n--;
        }
        partition(list,0,list.length-1);

        for(int i:list){
            System.out.println(i);
        }
    }
    static void partition(int[] array,int start, int end) {
        int left=start;
        int right=end;
        int pivot = array[(start+end)/2];
        while(start<=end) {
            while(array[start]<pivot) start++;
            while(array[end]>pivot) end--;
            if(start<=end) {
                int tmp = array[start];
                array[start]=array[end];
                array[end]=tmp;
                start++;
                end--;
            }
        }
        if(left<start-1)
        partition(array, left, start-1);
        if(start<right)
        partition(array, start,right);
    }
}
