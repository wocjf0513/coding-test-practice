import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도서관 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> leftQ=new PriorityQueue<>();
        PriorityQueue<Integer> rightQ=new PriorityQueue<>(Collections.reverseOrder()); 

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp=Integer.parseInt(st.nextToken());
            if(temp<0)
                leftQ.add(temp);
            else if(0<temp)
                rightQ.add(temp);
        }

        //-30 -18 -9

        //1 3 4 5

        //경우: 각 Q 두개나 하나 남았을 때 까지 멈추기

        //위의 경우에는, 절대 값 비교를 통해 큰 절대값은 왕복하지 않는다.

        int move=0;

        while(!(leftQ.isEmpty() && rightQ.isEmpty())){

            int cnt=0;
            
            if(leftQ.isEmpty()){
                move+=rightQ.poll();
                cnt=1;

                while(!rightQ.isEmpty()){
                    if(cnt==m)
                    break;

                    rightQ.poll();
                    cnt++;
                }
            }
            else if(rightQ.isEmpty()){
                move+=leftQ.poll()*(-1);
                cnt=1;

                while(!leftQ.isEmpty()){
                    if(cnt==m)
                    break;

                    leftQ.poll();
                    cnt++;
                }
            }
            else if(leftQ.peek()*(-1)<rightQ.peek()){
                move+=rightQ.poll();
                cnt=1;

                while(!rightQ.isEmpty()){
                    if(cnt==m)
                    break;

                    rightQ.poll();
                    cnt++;
                }
            }
            else{
                move+=leftQ.poll()*(-1);
                cnt=1;

                while(!leftQ.isEmpty()){
                    if(cnt==m)
                    break;

                    leftQ.poll();
                    cnt++;
                }
            }
            System.out.println(move);
            //처음 큰 거 하나 한번 갔다오기

            cnt=0; 

            while(!leftQ.isEmpty()){
                int tempQ=leftQ.poll();

                if(cnt%m==0){
                move+=tempQ*(-1)*2;
                }
                cnt++;

            }

            cnt=0; 

            while(!rightQ.isEmpty()){
                int tempQ=rightQ.poll();


                if(cnt%m==0){
                move+=tempQ*2;
                }
                cnt++;
            }

            }

            //2개 있거나 1개 있거나 없다.

        System.out.println(move);
        

     

    }
}
