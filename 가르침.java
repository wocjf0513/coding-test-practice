import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 가르침 {


    static ArrayList<String> words;
    static int n;
    static int max=Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken()); int k=Integer.parseInt(st.nextToken());
        // n은 단어의 개수, k는 배울 수 있는 글자의 개수

        words=new ArrayList<>();


        for(int i=0; i<n; i++){
            String inputStr=br.readLine();
            inputStr=inputStr.substring(4,inputStr.length()-4);
            String newStr="";
            for(char c:inputStr.toCharArray())
            {
                if(c=='a' || c=='n' || c=='t' || c=='i' || c=='c' ){

                }
                else{
                    if(!newStr.contains(c+""));
                    newStr+=c;
                }
            }       
            
            words.add(newStr);
        }

        int alphaCheck=1<<26;
        int wordCheck=1<<n;
        //초기 alphaCheck 값
        //0부터 시작

        //5개를 먼저 배웠으므로
        k=k-5;

        if(k<0)
        System.out.println(0);
        else{
            dfs(alphaCheck,wordCheck,k,0);
            System.out.println(max);
        }
        
      

    }
    public static void dfs(int alphaCheck, int wordCheck , int k, int count){

        if(wordCheck==((1<<n)-1)+(1<<n)){
            if(max<count)
            max=count;
            return;
        }
        
        int oriK=k;
        int oriA=alphaCheck;
        int oriW=wordCheck;

        for(int i=0; i<words.size(); i++){
            int temp[]=learnable(k, alphaCheck, words.get(i));
            if(temp[1]>=0 && (wordCheck&(1<<i))!=(1<<i)){
                k=temp[1];
                alphaCheck=temp[0];
                wordCheck|=(1<<i);
                dfs(alphaCheck, wordCheck, k, count+1);
                wordCheck=oriW;
                alphaCheck=oriA;
                k=oriK;
            }
            if(temp[1]<0 && (wordCheck&(1<<i))!=(1<<i)){
                wordCheck|=(1<<i);
                dfs(alphaCheck, wordCheck, k, count);
                wordCheck=oriW;
            }
        }
    }

    public static int[] learnable(int k, int alphaCheck, String s){

        for(char c:s.toCharArray()){
            if(k<0){
                return new int[]{alphaCheck,k};
            }
            int idx=1<<(c-'a');
            if((alphaCheck|idx)==idx){
                //배운 거
            }
            else{
                alphaCheck|=idx;
                k--;
            }
        }
        return new int[]{alphaCheck,k};
    }
 

    
}
