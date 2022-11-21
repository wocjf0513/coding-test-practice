package 아주대학교;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 목차세기 {
    
    public static void main(String[] args) throws IOException {
    //s=2 * (l-1)
    //(l-1)인 가장 아래의 상위제목과 관계
    //l제목과 l-1제목 사이는 l-1보다 작은 제목이있으면 안됨.
    //1레벨 최상위 , 2레벨이상 상위제목

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    
    int[] level=new int[n+1];

    for(int i=1; i<=n; i++){
        level[i]=Integer.parseInt(br.readLine());
    }
    boolean between=false;
    boolean parentB=false;

    StringBuilder sb=new StringBuilder();

    //1빼고는 상위제목이 있어야 한다.

    for(int i=1; i<=n; i++){
        int child=0;
        int tempL=level[i];
        between=false;
        parentB=false;
        if(tempL==1)
        parentB=true;

        for(int j=i+1; j<=n; j++){
            if(level[j]==tempL+1){
                if(between==true){
                    System.out.println(-1);
                    return;
                }
                child++;
            }
            else{
                if(tempL>level[j]){
                    between=true;
                }
                else if(tempL==level[j]){
                    break;
                }
            }
        }
        //상위 제목 체크
        if(parentB==false){
        for(int k=i-1; k>=1; k--){
            if(level[k]==tempL-1)
            {
                parentB=true;
                break;
            }
        }
        }
        if(parentB==false)
        {
            System.out.println(-1);
            return;
        }
        sb.append(Integer.toString(child)+"\n");
    }
    sb.deleteCharAt(sb.length()-1);
    System.out.println(sb.toString());


    }
    

    
}
