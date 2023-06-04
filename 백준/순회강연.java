import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 순회강연 {

    static long ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());


        class UnivCourse{
            int day;
            int pay;

            UnivCourse(int p, int d){
                day=d;
                pay=p;
            }
        }

        ArrayList<UnivCourse> Ulist=new ArrayList<>();

        for(int i=1; i<=n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            Ulist.add(new UnivCourse(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(Ulist,new Comparator<UnivCourse>() {

            @Override
            public int compare(UnivCourse o1, UnivCourse o2) {
                if(o1.day==o2.day){
                    return o2.pay-o1.pay;
                }
                return o1.day-o2.day;
                
            }
            
        });

        //날짜 오름차순 정렬 
        //날짜별 최대 갖을 수 있는 course 로 구성

        Iterator<UnivCourse> it=Ulist.iterator();


        int cnt=0;
        int curDay=0;
        while(it.hasNext()){
            UnivCourse temp=it.next();
            if(curDay!=temp.day){
                cnt=1;
                curDay=temp.day;
            }
            else{
                cnt++;
            }

            if(cnt>curDay){
                it.remove();
            }
            
        }

        PriorityQueue<UnivCourse> pq=new PriorityQueue<>(new Comparator<UnivCourse>() {

            @Override
            public int compare(UnivCourse o1, UnivCourse o2) {
                return o1.pay-o2.pay;
            }
            
        });


        for(int i=0; i<Ulist.size(); i++){
            int day=Ulist.get(i).day;

            if(pq.size()>=day){
                UnivCourse temp=pq.peek();
                if(Ulist.get(i).pay>temp.pay)
                {
                    pq.poll();
                    pq.add(Ulist.get(i));
                }
            }
            else{
                pq.add(Ulist.get(i));
            }

        }
        
        //계속 sorting 필요함... nlogn * n 번

        pq.stream().forEach(x->ans+=x.pay);


        System.out.println(ans);
    }


    
}
