import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 지름길 {
    
    static class Route{
        int start;
        int end;
        int len;

        Route(int s, int e, int l){
            start=s;
            end=e;
            len=l;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        Route[] routes=new Route[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int len=Integer.parseInt(st.nextToken());
            routes[i]=new Route(start,end,len);
        }
        Arrays.sort(routes,new Comparator<Route>() {

            @Override
            public int compare(지름길.Route o1, 지름길.Route o2) {
                // TODO Auto-generated method stub
                return o1.start-o2.start;
                
            }
            
        });

        long dp[]=new long[10001];

        for(int i=1; i<=d; i++){
            dp[i]=i;
        }


        for(int i=0; i<=d; i++){

            if(i!=0)
            dp[i]=Math.min(dp[i-1]+1,dp[i]);

            for(int r=0; r<n; r++){
                if(i<routes[r].start)
                break;

                if(i==routes[r].start && routes[r].end<=d){
                    int end=routes[r].end;

                    if(i!=0)
                    dp[end]=Math.min(dp[end],dp[i]+routes[r].len);
                    else
                    dp[end]=Math.min(dp[end],routes[r].len);


                }
            }
        }

        System.out.println(dp[d]);



        

        
        
    }
}
