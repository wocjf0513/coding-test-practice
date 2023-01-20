import java.util.Scanner;

public class 공일타일{

    //n =1 , 1
    //n =2 , 11 00
    //n =3 , 111 001 100 
    //n =4 , 1111 1001 1100 0011 0000
    //n =5 , 8개
    //4번째에 3 + 1을  2+ 00을 붙인다.
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        long[] binary=new long[1000001];
        binary[1]=1;
        binary[2]=2;
        for(int i=3; i<=n; i++){
            binary[i]=(binary[i-1]+binary[i-2])%15746;
        }
        System.out.println(binary[n]);
        in.close();
    }
}