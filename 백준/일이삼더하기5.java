import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class 일이삼더하기5 {

    static HashSet<String> dp[] = new HashSet[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int max=3;
        dp[1] = new HashSet<>();
        dp[1].add("1");
        dp[2] =new HashSet<>();
        dp[2].add("2");
        dp[3] =new HashSet<>();
        dp[3].add("3"); dp[3].add("12"); dp[3].add("21");

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n > max) {
                calDp(max, n);
                max = n;
            }
            bw.append(dp[n].size() + "\n");

            t--;
        }
        bw.flush();
        bw.close();

    }
    // dp 알고리즘만 짜면 됨.

   

     /**
      * 5= 2 -> 2  => 2 3 3 2
      * 4 -> 1 3 3 1 1 2 1 
      * 
      */
    public static void calDp(int max, int target) {
        //1,000,000,009 나누기
        for (int i = max + 1; i <= target; i++) {
            dp[i]=new HashSet<>();

            final int xIdx=i;

            //1
                dp[i-1].forEach(x->{
                    if(x.charAt(x.length()-1)!='1'){
                        dp[xIdx].add(x+"1");
                    }
                    if(x.charAt(0)!='1'){
                        dp[xIdx].add("1"+x);
                    }
                });

            //2
            
                dp[i-2].forEach(x->{
                    if(x.charAt(x.length()-1)!='2'){
                        dp[xIdx].add(x+"2");
                    }
                    if(x.charAt(0)!='2'){
                        dp[xIdx].add("2"+x);
                    }
                });

            //3
                
                dp[i-3].forEach(x->{
                    if(x.charAt(x.length()-1)!='3'){
                        dp[xIdx].add(x+"3");
                    }
                    if(x.charAt(0)!='3'){
                        dp[xIdx].add("3"+x);
                    }
                });

        }
    }




}
