import java.util.Scanner;

public class NQueen {
    static int avail=0;
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] board=new int[n+1];

        for(int i=1; i<=n; i++){
            board[1]=i;
            nQueenPlay(board, 2);

        }        
        System.out.println(avail);
        
    }

    public static void nQueenPlay(int[] board, int col){

        if(col==n+1){
            avail++;
            return;
        }
        for(int i=1; i<=n; i++){
            boolean chance=true;
            board[col]=i;
            for(int j=1; j<col; j++){
                if(board[j]==i || Math.abs(board[j]-i)==Math.abs(j-col)){
                    chance=false;
                    break;
                }
            }
            if(chance)
            nQueenPlay(board, col+1);
        }
    }
}
