import java.util.Scanner;

public class 연산자끼워넣기 {
    static int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        arr=new int[n];
        int[] math=new int[4];
        //+ - x /
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();   
        }
        for(int i=0; i<4; i++){
            math[i]=sc.nextInt();
        }

        cal(1,arr[0],math);

        System.out.println(max);
        System.out.println(min);

        


    }
    public static void cal(int order,int sum, int[] math){
        if(order==n)
        {
            if(sum<min)
            min=sum;
            if(sum>max)
            max=sum;

            return;
        }
        for(int i=0; i<4; i++){
            if(math[i]>0)
            {
                int temp=sum;
                System.out.println(i);
                math[i]=math[i]-1;
                switch(i){
                    case 0:
                    sum+=arr[order];
                    break;
                    case 1: 
                    sum-=arr[order];
                    break;
                    case 2:
                    sum*=arr[order];
                    break;
                    case 3:
                    if(sum<0){
                    sum=Math.abs(sum);
                    sum/=arr[order];
                    sum=-sum;
                    }
                    else
                    sum/=arr[order];
                    break;
                }
                cal(order+1,sum,math);
                math[i]=math[i]+1;
                sum=temp;
            }

        }



    }
    
}
