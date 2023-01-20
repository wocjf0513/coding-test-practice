import java.util.Scanner;

public class 신나는함수실행 {
    static int[][][] list=new int[21][21][21];
    public static void main(String[] args) {
        list[0][0][0]=1;
        Boolean exitBit=true;
        Scanner sc=new Scanner(System.in);
        while(exitBit){
     
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if(a==-1 && b==-1 && c==-1)
        exitBit=false;
        else{
        if(a<=0 || b<=0 || c<=0)
        System.out.println(1);
        else{
            System.out.println(dynamicW(a, b, c));
        }
    }
    }
}
    public static int dynamicW(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0){
        list[a][b][c]=1;
        return list[a][b][c];
        }
        else if(a>20 || b>20 || c>20)
        return dynamicW(20, 20, 20);
        else if(list[a][b][c]==0 && (a<b && b<c)){
        list[a][b][c]=dynamicW(a, b, c-1) + dynamicW(a, b-1, c-1) -dynamicW(a, b-1, c);
        return list[a][b][c];
        }
        else if(list[a][b][c]==0){
        list[a][b][c]=dynamicW(a-1, b, c) + dynamicW(a-1, b-1, c) + dynamicW(a-1, b, c-1) - dynamicW(a-1, b-1, c-1);
        return list[a][b][c];
        }
        else
        return list[a][b][c];


    }
}

