import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게임개발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[] dp=new int[n+1];
        int[] in=new int[n+1];
        

        StringTokenizer st;
        
        ArrayList<Integer> list[]=new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            list[i]=new ArrayList<>();
            while(st.hasMoreTokens()){
                int temp=Integer.parseInt(st.nextToken());
                if(temp==-1){
                    break;
                }
                list[i].add(temp);
            }
        
            in[i]=list[i].get(0);
            list[i].remove(0);

            //System.out.println(list[i].size());
            //이제 남은 건 먼저 지어져야 할 건물
        }


        //입력 받아짐
        
        boolean everyBuild=false;

        
        while(!everyBuild){
            everyBuild=true;
            for(int i=1; i<=n; i++){
                if(list[i].size()>=1){
                    for(int j=0; j<list[i].size(); j++){
                        int needBuild=list[i].get(j);
                        if(list[needBuild].size()==0){
                            //선행 건물이 없는 
                            dp[i]=Math.max(dp[i],in[needBuild]+dp[needBuild]);
                            list[i].remove(j);
                        }
                    }
                    everyBuild=false;
                }
            }
        }
        
        
        for(int i=1; i<=n; i++){
            System.out.println(in[i]+dp[i]);
        }
        

        
        




        //모든 건물이 완성되기까지 걸리는 최소 시간
    }
    //걸리는 시간 - 먼저 지어져야할 건물- -1
    
}
