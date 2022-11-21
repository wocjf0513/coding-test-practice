package 아주대학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 예쁜수 {

    static int m;
    static ArrayList<String> al2=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        ArrayList<Integer> al=findN(m);

        int[] checkN=new int[m+1];
        
        dfs(al,m,0,checkN);

        System.out.println(al2.size()&k);
        
        for(String s:al2)
        System.out.println(s);
    }
    public static ArrayList<Integer> findN(int m){
        ArrayList<Integer> temp=new ArrayList<>();

        for(int i=1; i<=m; i++){
            if(m%i==0)
            temp.add(i);
        }
    
        return temp;
    }
    public static void dfs(ArrayList<Integer> list, int m, int sum, int[] checkN){
        if(sum>=m)
        {
            if(sum==m){
            String s="";
            for(int i:checkN)
            s+=Integer.toString(i);
            System.out.println(s);
            if(!al2.contains(s))
            al2.add(s);
            }

            return;
        }
        for(int i=0; i<list.size(); i++){
            int temp=list.get(i);
            checkN[temp]++;
            sum+=temp;
            dfs(list,m,sum,checkN);
            sum-=temp;
            checkN[temp]--;
        }
    }
}
