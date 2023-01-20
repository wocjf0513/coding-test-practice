import java.util.Scanner;

public class 수정렬하기2 {
    static int index=0;
    static int[] list;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        final int count=n;
        list=new int[n];
        while(n!=0){
            list[count-n]=sc.nextInt();
            n--;
        }
        merge(0, list.length-1);
        
        for(int i:list){
            System.out.println(i);
        }
        
    }
    public static void merge(int left, int right){
        if(left==right)
        return;

        int index=0;
        int[] sorted=new int[right-left+1];

        int mid=(left+right)/2;
        merge(left, mid);
        merge(mid+1, right);

        int pl=left;
        int pr=mid+1;
        while(pl<pr&& pr<=right){
            if(list[pl]<list[pr])
                sorted[index++]=list[pl++];
            else
                sorted[index++]=list[pr++];
        }
        while(pl<=mid)
        sorted[index++]=list[pl++];
        while(pr<=right)
        sorted[index++]=list[pr++];

        int idx=0;
        for(int i=left; i<=right; i++)
        list[i]=sorted[idx++];
    }
    
}
