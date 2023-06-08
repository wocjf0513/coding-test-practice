import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 미세먼지안녕{
    static int[][] map;
    static int mapR,mapC;
    static int airConTop;
    static int ariConBottom;
    static int T;

    static int[][] copyMap;
    static int[] dir=new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException {
        //공기청정기 1번열, 크기 두 행. 
        /*[1초 동안의 동작]
         * 미세먼지 확산 , 확산되는 양 A/5 , 소수점 버림
         * 확산 원인 장소에 미세먼지 양 A- A/5 * 확산된 방향의 개수
         * 
         * 그 다음 행동
         * 공기청정기 작동 위쪽은 반 시계 방향, 아래 쪽은 시계 방향 
         */

         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());

         mapR=Integer.parseInt(st.nextToken());
         mapC=Integer.parseInt(st.nextToken());
         T=Integer.parseInt(st.nextToken());


         map=new int[mapR][mapC];

         for(int i=0; i<mapR; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<mapC; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(airConTop==0 && map[i][j]==-1){
                    airConTop=i;
                }
                else if(airConTop!=0 && map[i][j]==-1){
                    ariConBottom=i;
                }
            }
         }

         for(int tempT=1; tempT<=T; tempT++){
            copyMap=new int[mapR][mapC];
            for(int i=0; i<mapR; i++){
                for(int j=0; j<mapC; j++){
                    if(map[i][j]!=-1 && map[i][j]!=0){
                        spread(i,j,copyMap);
                    }
                    else{
                        copyMap[i][j]+=map[i][j];
                    }
                }
            }
            copy(copyMap,map);
   
        
            
    
            operateAirConditioner(airConTop, true);
            operateAirConditioner(ariConBottom, false);

      
        }

        System.out.println(sumDust());






         
    }
    public static void showMap(){
        for(int i=0; i<mapR; i++){
            for(int j=0; j<mapC; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static long sumDust(){
        long ans=0;
        for(int i=0; i<mapR; i++){
            for(int j=0; j<mapC; j++){
                if(map[i][j]!=-1)
                ans+=map[i][j];
            }
        }
        return ans;
    }
    public static void copy(int[][] source, int[][] goal){
        for(int i=0; i<source.length; i++){
            for(int j=0; j<source[0].length; j++){
                goal[i][j]=source[i][j];
            }
        }
    }
    public static void spread(int R, int C,int[][] copyMap){
        int newR, newC;
        int speardCount=0;
        int dust=map[R][C];

        Deque<int[]> dq=new LinkedList<>();
        for(int i=0; i<=3; i++){
            newR=R+dir[i];
            newC=C+dir[3-i];

            if(newR<0 || newC<0 || newR>=mapR || newC>=mapC || map[newR][newC]==-1){
                continue;
            }
            dq.add(new int[]{newR,newC});
            speardCount++;
        }

        copyMap[R][C]+=dust-((dust/5)*speardCount);
    
        while(!dq.isEmpty()){
            int[] temp=dq.poll();
            copyMap[temp[0]][temp[1]]+=dust/5;
        }


    }
    //현재 값 저장(temp) -> 이전 값(temp2)을 map 현재에 넣어줌. -> temp2=temp;
    public static void operateAirConditioner(int ContionerPos, boolean UpContioner){
        //C는 1부터 시작.. 
        //조건 처음에는 J++하다가, J가 최대가 되었을 때 I를 ++ 나 --, I가 최소가 되거나 최대가 되면, J--, J가 최소가 되거나 최대가 되면 I를 ++나 --

        int statusCode=0;
        int temp2=0;

        int tempR=ContionerPos,tempC=1;
        
        while(true){

            if(map[tempR][tempC]==-1){
                break;
            }
            else{
                int temp=map[tempR][tempC];
                map[tempR][tempC]=temp2;
                temp2=temp;
            }

                switch(statusCode){
                    case 0:tempC++;
                    break;
                    case 1:tempR--;
                    break;
                    case 2:tempC--;
                    break;
                    case 3:tempR++;
                    break;
                }

                    if(UpContioner==true){
                        if(tempR==ContionerPos && tempC==mapC-1){
                            statusCode=1;
                        }
                        if(tempR==0 && tempC==mapC-1){
                            statusCode=2;
                        }
                        if(tempR==0 && tempC==0){
                            statusCode=3;
                        }
                    }
                    else{
                        if(tempR==ContionerPos && tempC==mapC-1){
                            statusCode=3;
                        }
                        if(tempR==mapR-1 && tempC==mapC-1){
                            statusCode=2;
                        }
                        if(tempR==mapR-1 && tempC==0){
                            statusCode=1;
                        }
                    }
        }
    }
}