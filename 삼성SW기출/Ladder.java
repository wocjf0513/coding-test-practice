/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Ladder
{
    static int[][] ladder;
	public static void main(String args[]) throws Exception
	{
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        Scanner sc=new Scanner(System.in);

		for(int test_case = 1; test_case <= 1; test_case++)
		{
            test_case=sc.nextInt();

            ladder=new int[101][101];

            for(int i=1; i<=100; i++){
                for(int j=1; j<=100; j++){
                    ladder[i][j]=sc.nextInt();
                }
            }

            //알고리즘
            //(1)바닥인가 (2)좌우 (3) 밑
            for(int i=1; i<=100; i++){
                if(ladder[1][i]==1){
                    if(search(i)){
                        System.out.println("#"+test_case+" "+(i-1));
                        break;
                    }
                }
            }
            
		}
	}
    public static boolean search(int x){


        boolean check[][]=new boolean[101][101];

        for(int i=1; i<=100;){
            check[i][x]=true;
            if(ladder[i][x]==2)
            return true;

            if(1<=x-1 && !check[i][x-1] && ladder[i][x-1]==1){
                x--;
            }
            else if(x+1<=100 && !check[i][x+1] && ladder[i][x+1]==1){
                x++;
            }
            else{
                i++;
            }
        }

        return false;


    }
}