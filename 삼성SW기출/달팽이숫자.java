import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 달팽이숫자 {

    static int dir[]={0,1,0,-1};
    static int dir2[]={1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=t; i++){
            int n=Integer.parseInt(br.readLine());


            int[][] ans=new int[n][n];
            //초반에는 오른쪽으로 갑니다.
            //해당 인덱스가 1~n까지를 벗어나거나 값이 원래 있다면 방향을 바꿉니다. 바꿔지는 순서는 오른쪽, 아래, 왼쪽, 위 입니다.


            bw.append("#"+i+"\n");

            int c=0,r=0,Idx=0,cnt=1;
            boolean check=false;
            while(true){
                if(0<=r && r<n && 0<=c && c<n && ans[c][r]==0){
                    //해당 값에 대입
                    ans[c][r]=cnt;
                    cnt++;
                    check=false;
                }
                else{
                    //방향 바꾸기
                    if(check){
                        break;
                    }
                    else{
                        check=true;
                    }
                    c-=dir[Idx];
                    r-=dir2[Idx];

                    if(Idx==3)
                    Idx=0;
                    else{
                        Idx++;
                    }
                }
                
                c+=dir[Idx];
                r+=dir2[Idx];
            }
            
            for(int k=0; k<n; k++){
                for(int j=0; j<n; j++){
                    bw.append(ans[k][j]+" ");

                }
                bw.append("\n");
            }
            
          
        }
        bw.flush();bw.close();br.close();

    }
    
}
