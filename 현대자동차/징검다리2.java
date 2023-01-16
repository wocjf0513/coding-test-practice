import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] height=new long[n];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            height[i]=Long.parseLong(st.nextToken());
        }

        int[] upDp=new int[n];
        long[] helper=new long[n];
        helper[0]=height[0];
        int top=0;
        upDp[0]=1;

        //올라갔다가 내려간다.
        for(int i=1; i<n; i++){
                if(helper[top]<height[i]){
                    top++;
                    helper[top]=height[i];
                    upDp[i]=top+1;
                }
                else{
                    int idx=binarySearch(helper,0, top, height[i]);
                    helper[idx]=height[i];
                    upDp[i]=idx+1;
                }
        }

        int[] downDp=new int[n];
        helper=new long[n];
        helper[0]=height[n-1];
        top=0;
        downDp[n-1]=1;

        for(int i=n-2; i>=0; i--){
            if(helper[top]<height[i]){
                top++;
                helper[top]=height[i];
                downDp[i]=top+1;
            }
            else{
                int idx=binarySearch(helper,0, top, height[i]);
                helper[idx]=height[i];
                downDp[i]=idx+1;
            }
    }

        // long max=0;

        // for(int i=0; i<n; i++){
        //     if(i==0){
        //         max=Math.max(max, downDp[i]);
        //     }
        //     else if(i==n-1){
        //         max=Math.max(max, upDp[i]);
        //     }
        //     else
        //     max=Math.max(max, upDp[i]+downDp[i+1]);
        // }
        // System.out.println(max);


        Arrays.stream(upDp).forEach(System.out::print);
        System.out.println();
        Arrays.stream(downDp).forEach(System.out::print);
    }
    
    public static int binarySearch(long[] height, int left, int right, long target){
        int mid;

        while(left<right){
            mid=(left+right)/2;
            if(height[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }

        return right;


    }



}
