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
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 공통조상
{
    
    static LinkedList<Integer>[] parentT;
    static LinkedList<Integer>[] childT;

	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int ans=0;
            int v=sc.nextInt();
            int e=sc.nextInt();
            int findV1=sc.nextInt();
            int findV2=sc.nextInt();
            boolean[] check=new boolean[v+1];
            //check를 통해 조상들을 check나갈 것이다.

            //boolean[][] graph=new boolean[v+1][v+1];
            //이렇게 하면 v만큼 loop를 반복해야 하기 때문에 

            parentT=new LinkedList[v+1];
            childT=new LinkedList[v+1];

            for(int i=1; i<=v; i++){
                parentT[i]=new LinkedList<>();
                childT[i]=new LinkedList<>();
            }

            for(int i=0; i<e; i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();

                childT[v2].add(v1); //v2는 v1의 자식이다.
                parentT[v1].add(v2);
            }


            search(test_case,findV1,findV2,check);
            
            
            //위로 올라가기 때문에 자식-> 부모 관계만 boolean

		}
	}
    public static void search(int test_case,int findV1, int findV2, boolean[] check){

        //둘다 순회하면서 자기, 자신의 조상들 check해 나감.

        while(!check[findV1]){
            check[findV1]=true;


            for(int parent: childT[findV1]){
                findV1=parent;
            }
        }

        while(!check[findV2]){
            check[findV2]=true;


            for(int parent: childT[findV2]){
                findV2=parent;
            }
        }

        int parent=findV2;

        Deque<Integer> dq=new LinkedList<>();
        dq.add(parent);
        int size=1;

        while(!dq.isEmpty()){
            int temp=dq.poll();
            
            for(int child:parentT[temp]){
                dq.add(child);
                size++;
            }
        }

        System.out.println("#"+test_case+" "+parent+" "+size);
        //bfs를 통해 크기 계산하기!!
        
        
    }
}