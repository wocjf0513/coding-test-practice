import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
public class 단어수학{

    static int temp=9;

    public static void main(String[] args) throws IOException {

        //1. 높은 자리 수, 빈도가 높은 알파벳에 높은 숫자를 배정해준다.

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        String[] arr=new String[n];

        for(int i=0; i<n; i++){
            arr[i]=br.readLine();
        }

        //최대 80
        //자릿수를 받은 배열, 알파벳을 받는 배열
        
        ArrayList<Pair> list=new ArrayList<>();

        for(String s:arr){
            for(int i=0; i<s.length(); i++){
                list.add(new Pair(s.charAt(i),s.length()-i));
            }
        }

        Collections.sort(list,new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getY()-o1.getY();
            }
        });

        HashMap<Character,Integer> map=new HashMap<>();

        list.forEach(x->{
            if(!map.containsKey(x.getX())){
            map.put(x.getX(),(int)(Math.pow(10,x.getY()-1)));
            }
            else{
                map.put(x.getX(),map.get(x.getX())+(int)(Math.pow(10,x.getY()-1)));
            }
        });

        List<Entry<Character, Integer>> map_entries = new ArrayList<Entry<Character, Integer>>(map.entrySet());
        Collections.sort(map_entries,new Comparator<Entry<Character, Integer>>() {

            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        
        HashMap<Character,Integer> alpha_value=new HashMap<>();


        map_entries.forEach(x->{
            alpha_value.put(x.getKey(),temp);
            temp--;
        });

        int sum=0;

        for(String s:arr){
            for(int i=0; i<s.length(); i++){
               sum+=alpha_value.get(s.charAt(i))*Math.pow(10,s.length()-1-i);
            }
        }
        System.out.println(sum);

        

        
        

    }
}
class Pair {
    private char x;
    private int y;

    public Pair(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}