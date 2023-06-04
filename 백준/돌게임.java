import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

         int n=Integer.parseInt(br.readLine());

         int[] stoneGame=new int[n+1];
        if(stoneGame.length>=2){
            stoneGame[1]=1;
        }
        if(stoneGame.length>=3){
            stoneGame[2]=2;
        }
        if(stoneGame.length>=4){
            stoneGame[3]=1;
        }

         for(int i=4; i<=n; i++){
            stoneGame[i]=stoneGame[i-1]+stoneGame[1];
         }
         
         if(stoneGame[n]%2==0)
         System.out.println("CY");
         else{
            System.out.println("SK");
         }

        
    }
    // 돌 게임은 두 명이서 즐기는 재밌는 게임이다.
    // 탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 
    // 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
    // 두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
    
    //3이나 1로 나누기를 해서 1이 되거나 2가 남으면 유리한 게임.. 
        
}
