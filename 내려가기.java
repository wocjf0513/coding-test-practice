import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[][][] score=new int[n+1][2][2];
        //0번이 이전꺼
        //1번이 최근꺼


        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                if(i==1){
                score[j][0][0]=Integer.parseInt(st.nextToken());
                score[j][0][1]=score[j][0][0];
                System.out.print("max value:"+score[j][0][0]+"   ");
                }
                else{
                    score[j][1][0]=Integer.parseInt(st.nextToken());//최대
                    score[j][1][1]=score[j][1][0];//최소
                    if(j==1){
                    score[j][1][0]+=Math.max(score[j][0][0],score[j+1][0][0]);
                    score[j][1][1]+=Math.min(score[j][0][1],score[j+1][0][1]);
                    }
                    else if(j==n){
                    score[j][1][0]+=Math.max(score[j][0][0],score[j-1][0][0]);
                    score[j][1][1]+=Math.min(score[j][0][1],score[j-1][0][1]);
                    }
                    else{
                        int plus=Math.max(score[j][0][0],score[j-1][0][0]);
                        plus=Math.max(plus,score[j+1][0][0]);
                        score[j][1][0]+=plus;
                        int minus=Math.min(score[j][0][1],score[j-1][0][1]);
                        minus=Math.min(plus,score[j+1][0][1]);
                        score[j][1][1]+=minus;
                    }
                    
                score[j][0][0]=score[j][1][0];
                score[j][0][1]=score[j][1][1];

                }
                
            }
            System.out.println();
        }


        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            if(max<score[i][1][0])
            max=score[i][1][0];
            if(min>score[i][1][1])
            min=score[i][1][1];
        }
        System.out.print(max+" "+min);



       
        
        //각 차례의 max를 구하자.


    }
    }
    