import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백만장자프로젝트2{
    

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
            for(int c=1; c<=t; c++){
                int n=Integer.parseInt(br.readLine());
                int[] tagList=new int[n+1];
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int i=1; i<=n; i++){
                    tagList[i]=Integer.parseInt(st.nextToken());
                }
                int max=tagList[n];
                long ans=0;
                for(int i=n-1; i>=1; i--){
                    if(max>tagList[i]){
                       ans+=max-tagList[i];
                    }
                    else{
                        max=tagList[i];
                    }
                }
                bw.append("#"+c+" "+ans+"\n");

            

                /*뒤에서 부터 마지막 값을 max로 뒀을 때 max보다 현재 인덱스 값이 크면 max 교체, 이윤 없음
                max가 크면 max-해당 인덱스 값만큼 이윤이 증가된다. 
                */

            }
        bw.flush();
        bw.close();
        br.close();
        }

    }