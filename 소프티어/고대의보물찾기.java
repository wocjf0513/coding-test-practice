import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.GuardedObject;

public class 고대의보물찾기 {

    static String s;

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s=br.readLine();

        String find=br.readLine();

        int left=0;
        int right=0;
        int click=0;

        int previous=0;
        int goal=0;

        click=find.length();

        for(int i=0; i<find.length(); i++){
            goal=s.indexOf(find.charAt(i));
            if(goal==-1){
            System.out.println(-1);
            break;
            }
            else{
                int leftN=left(previous,goal);
                int rightN=right(previous,goal);
                if(leftN<rightN)
                left+=leftN;
                else{
                    right+=rightN;
                }
            }
            previous=goal;
            if(i==find.length()-1)
            System.out.println((click+right+left)+" "+left+" "+right);
        }
        
        //아스키 값으로 뺀거중 가까운 거
        //중심
	}
    static int right(int index, int goal){
        int dis=0;

        for(int i=index; i>=-1; i--){
            if(i==-1)
            i=s.length()-1;

            if(i==index)
            dis=0;
            else
            dis++;

            if(i==goal)
            break;

        }
        return dis;


    }
    static int left(int index, int goal){
        int dis=0;

        for(int i=index; i<=s.length(); i++){
            if(i==s.length())
            i=0;

            if(i==index)
            dis=0;
            else
            dis++;

            if(i==goal)
            break;

        }
        return dis;
    }
    //왼쪽, 오른쪽, 클릭
    
}
