import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int n,m;
    static int d;
    static int[][] map;
    static int ans=0;
    static int directionR[]={1,0,-1,0};
    static int directionC[]={0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());

        // d가 동:1 서:3 남:2 북:0

        st=new StringTokenizer(br.readLine());

        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        
        map=new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //0이면 청소x, 1이면 벽

        //시뮬레이션 시작
       /*1. 현재 칸이 청소 x 이면 청소
       2.동서남북 네 칸중 청소 칸이 있으면, 반시계 90도 회전, 
       동->북->서->남, 앞 칸이 청소 x 이면 전진
       3.없으면, 후진, 뒤쪽이 벽이면 작동 멈춤.
       =>청소하는 영역의 개수 구하기
       */

       while(true){
            cleanHere(r, c);
            showMap();
            
            if(isAroundCleaned(r, c)){
                while(true){
                    rotate();
                    int newR=r+directionR[d];
                    int newC=c+directionC[d];
                    if(isNotCleaned(newR, newC)){
                        r=newR;
                        c=newC;
                        break;
                    }
                }
            }
            else{
                int newR=r-directionR[d];
                int newC=c-directionC[d];

                if(0<newR && 0<newC && newR<n && newC<m){
                    if(map[newR][newC]!=1){
                        r=newR;
                        c=newC;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }

            }
       }

       System.out.println(ans);

       

    }
    public static void showMap(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isNotCleaned(int r, int c){
        if(0<=r && 0<=c && r<n && c<m){
            //가능 조건
            if(map[r][c]==0){
                return true;
            }
        }
        return false;
    }

    public static void cleanHere(int r, int c){
        if(map[r][c]==0){
            System.out.println("청소한 위치: "+r+", "+c +"   청소한 영역 개수:"+ans+" 방향:"+d);
            ans++;
            map[r][c]=2; //청소한 상태
        }
    }

    
    public static boolean isAroundCleaned(int r,int c){
        Boolean isAroundClean=false;
        for(int i=0; i<=3; i++){
            int newR=r+directionR[i];
            int newC=c+directionC[i];

            if(isNotCleaned(newR, newC))
            isAroundClean=true;
            }
        return isAroundClean;
    }
    public static void rotate(){
        if(d==0){
            d=3;
        }
        else{
            d-=1;
        }
    }
    
}
