import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ACMCraft {   
    
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int tN=1; tN<=t; tN++){
        st=new StringTokenizer(br.readLine());
        int bN=Integer.parseInt(st.nextToken());
        int sN=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        int[] bList=new int[bN+1];
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int[] dpTime=new int[bN+1];
        ArrayList<Integer> checkStart=new ArrayList<>();

        for(int i=1; i<=bN; i++){
        bList[i]=Integer.parseInt(st.nextToken());
        checkStart.add(i);
        map.put(i,new ArrayList<Integer>());
        }


        for(int i=1; i<=sN; i++)
        {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int dest=Integer.parseInt(st.nextToken());

            if(checkStart.contains(dest))
            {
                checkStart.remove(new Integer(dest));
            }
            
            map.get(start).add(dest);

            //시작 지점 구하기 
        }
        
        int findB=Integer.parseInt(br.readLine()); //구해야할 건물

        int startB=checkStart.get(0);
    
        //시작 지점 구한다음 => max time

        calTime(bList, map, dpTime, startB);
        System.out.println(dpTime[findB]);
    }




    }
    public static void calTime(int[] bList, HashMap<Integer,ArrayList<Integer>> map, int[] dpTime, int idx){
        
        Deque<int[]> que=new LinkedList<>();
        que.add(new int[]{idx,bList[idx]});
        dpTime[idx]=bList[idx];

        while(!que.isEmpty()){
            int temp[]=que.poll();
            //temp[0] : idx
            //temp[1] : 건설 시간
            if(dpTime[temp[0]]<temp[1])
            dpTime[temp[0]]=temp[1];
            for(int dest:map.get(temp[0])){
                que.add(new int[]{dest,temp[1]+bList[dest]});
            }
        }
        
        
    }
}


//테스트 개수 1
//건물 개수, 순서 개수 4 4
//코스트 10 10 10 10
//순서 
/* 1 2
 * 1 3
 * 2 4
 * 3 4
 */
