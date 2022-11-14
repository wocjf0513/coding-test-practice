import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class 수리공환승{
    public static void main(String[] args) throws IOException {
        //물 새는 곳을 막기위해 0.5 좌우 
        //sorting해서 처음꺼 -0.5 부터 한개로 커버되는 거까지 넘기고 다시 -0.5부터 반복!!
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());

        int[] nList=new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            nList[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nList);

        int first=0;
        int LCount=0;

        for(int i=1; i<=n; i++){
            if(first<nList[i]){
            first=(nList[i]-1+l); //여기까지 붙일 수 있다.
            LCount++;
            }
            
        }
        System.out.println(LCount);
    }

}