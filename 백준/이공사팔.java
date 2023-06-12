import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이공사팔 {

    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] temp=new int[n][n]; //0부터 시작

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                temp[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        bfs(temp,0);

        System.out.println(max);

        
       
        //한번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없다.
        
    }
    public static void bfs(int[][] temp,int count){
        if(count==5){
            int len=temp.length;
            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    max=Math.max(temp[i][j],max);
                }
            }
            return;
        }
        for(int i=0; i<4; i++){
            bfs(moveBoard(temp, i),count+1);
        }
    }
    public static int[][] moveBoard(int[][] temp,int dir){
        int len=temp.length;
        if(dir==0){
            //동
            for(int i=0; i<len; i++){
                for(int j=len-1; j>0; j--){
                    for(int k=j-1; k>=0; k--){
                        if(temp[i][j]==temp[i][k]){
                            temp[i][j]*=2;
                            temp[i][k]=0;
                            break;
                        }
                        if(temp[i][k]!=0 && temp[i][j]!=temp[i][k]){
                            break;
                        }
                    }
                }
            }

            for(int i=0; i<len; i++){
                for(int j=len-1; j>0; j--){
                    if(temp[i][j]==0){
                        for(int k=j-1; k>=0; k--){
                            if(temp[i][k]!=0){
                                temp[i][j]=temp[i][k];
                                temp[i][k]=0;
                                break;
                            }
                        }
                    }
                }
            }

        }
        else if(dir==1){
            //서
            
            for(int i=0; i<len; i++){
                for(int j=0; j<len-1; j++){
                    for(int k=j+1; k<len; k++){
                        if(temp[i][j]==temp[i][k]){
                            temp[i][j]*=2;
                            temp[i][k]=0;
                            break;
                        }
                        if(temp[i][k]!=0 && temp[i][j]!=temp[i][k]){
                            break;
                        }
                    }
                }
            }

            
            for(int i=0; i<len; i++){
                for(int j=0; j<len-1; j++){
                    if(temp[i][j]==0){
                        for(int k=j+1; k<len; k++){
                            if(temp[i][k]!=0){
                                temp[i][j]=temp[i][k];
                                temp[i][k]=0;
                                break;
                            }
                        }
                    }
                }
            }
 

        }
        else if(dir==2){
            //남
      
            for(int i=0; i<len; i++){
                for(int j=len-1; j>0; j--){
                    for(int k=j-1; k>=0; k--){
                        if(temp[j][i]==temp[k][i]){
                            temp[j][i]*=2;
                            temp[k][i]=0;
                            break;
                        }
                        if(temp[k][i]!=0 && temp[j][i]!=temp[k][i]){
                            break;
                        }
                    }
                }
            }
            
            for(int i=0; i<len; i++){
                for(int j=len-1; j>0; j--){
                    if(temp[j][i]==0){
                        for(int k=j-1; k>=0; k--){
                            if(temp[k][i]!=0){
                                temp[j][i]=temp[k][i];
                                temp[k][i]=0;
                                break;
                            }
                        }
                    }
                }
            }

          


        }
        else{
            //북
            for(int i=0; i<len; i++){
                for(int j=0; j<len-1; j++){
                    for(int k=j+1; k<len; k++){
                        if(temp[j][i]==temp[k][i]){
                            temp[j][i]*=2;
                            temp[k][i]=0;
                            break;
                        }
                        if(temp[k][i]!=0 && temp[j][i]!=temp[k][i]){
                            break;
                        }
                    }
                }
            }
    
            for(int i=0; i<len; i++){
                for(int j=0; j<len-1; j++){
                    if(temp[j][i]==0){
                        for(int k=j+1; k<len; k++){
                            if(temp[k][i]!=0){
                                temp[j][i]=temp[k][i];
                                temp[k][i]=0;
                                break;
                            }
                        }
                    }
                }
            }

            

        }
        return temp;
    }
    
    
}
