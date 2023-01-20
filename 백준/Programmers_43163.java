import java.util.*;


public class Programmers_43163{

    static String[] words=new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    static boolean[] checked=new boolean[words.length];
    static int min_search=Integer.MAX_VALUE;
    public static void main(String args[]){
        solution("hit","cog",words);
    }
    public static int solution(String begin, String target, String[] words) {
        int answer =10000;
        dfs(begin,target,0,words);
        if(min_search==Integer.MAX_VALUE)
        return 0;
        return answer;

    }
    public static void dfs(String source, String target, int count,String[] words){
        if(source==target){
            if(min_search>count)
            min_search=count;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(alpha1(source,words[i]) && !checked[i]){
                checked[i]=true;
                dfs(words[i],target,count+1,words);
                checked[i]=false;
            }

        }
    }
    public static boolean alpha1(String source,String source2){
        int count=0;
        for(int i=0; i<source.length(); i++)
        {
            if(source.charAt(i)!=source2.charAt(i))
            count++;
        }
        if(count==1)
        return true;
        else
        return false;
    }
}