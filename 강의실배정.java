import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 강의실배정 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

      

        int[][] times=new int[n+1][2];
        int[] check=new int[n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            times[i][0]=Integer.parseInt(st.nextToken());
            times[i][1]=Integer.parseInt(st.nextToken());
            check[i]=1;
        }

        Arrays.sort(times,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                return o1[1]-o2[1];
                else
                return o1[0]-o2[0];
            }
            
        });


        Queue<Integer> q = new LinkedList();
		int endTime=0;

        for(int i=1; i<=n; i++){
            endTime=times[i][1];

            if(!q.isEmpty() && q.peek() <= times[i][0]) {
				q.poll();
			}
            q.add(endTime);
        }
	
        System.out.println(q.size());
        br.close();
        //끝나는 시간이 빠른거별로 정렬
        //강의실의 개수


        
        
        
        
    }

    //최소의 강의실, 수업이 끝난 직후 다음 수업
    //끝나는 시간이랑 시작시간이 같아도 수업을 들을 수 있다.

}
