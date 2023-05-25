import java.util.Scanner;

class 블랙잭{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int[] list=new int[n+1];

        for(int i=1; i<=n; i++)
        list[i]=sc.nextInt();

        int max=0;
        int checker=Integer.MAX_VALUE;

        for(int i=1; i<list.length; i++){
            for(int j=1; j<list.length; j++){
                for(int k=1; k<list.length; k++){
                    if(i!=j && j!=k && k!=i){
                        int sum=list[i]+list[j]+list[k];
                        if(sum<=m && Math.abs(m-sum)<checker ){
                        checker=Math.abs(m-sum);
                        max=sum;
                        }
                    }

        }
       }
    }
    System.out.println(max);
    }
}