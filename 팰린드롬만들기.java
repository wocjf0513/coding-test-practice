import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 팰린드롬만들기 {


    public static void main(String[] args) throws IOException {
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] source=br.readLine().toCharArray();

        Arrays.sort(source);

        int[] alpha=new int[26];
        char answer[]=new char[source.length];

        Deque<Character> dq=new LinkedList<>();

        for(char c:source){
            alpha[c-'A']++;
            dq.add(c);
        }

        int oddAlpha=-1;
        
        for(int i=0; i<26; i++){
            if(alpha[i]%2==1 &&oddAlpha==-1){
                oddAlpha=i;
            }
            else if(alpha[i]%2==1 &&oddAlpha!=-1){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        if(oddAlpha==-1){
            //짝수인경우
            for(int i=0; i<source.length/2; i++)
            {
                
                if(!dq.isEmpty())
                answer[i]=dq.poll();
                if(!dq.isEmpty())
                answer[source.length-1-i]=(dq.poll());
            }
            for(char c:answer)
            System.out.print(c);
        }
        else{
            //홀수인경우
            String left="";
            String right="";
            dq.remove((char) ('A'+oddAlpha));
            for(int i=0; i<source.length/2; i++)
            {
                if(!dq.isEmpty())
                answer[i]=dq.poll();
                if(!dq.isEmpty())
                answer[source.length-1-i]=(dq.poll());
            }
            answer[source.length/2]=(char)(oddAlpha+'A');
            for(char c:answer)
            System.out.print(c);
        }
    }
}
        