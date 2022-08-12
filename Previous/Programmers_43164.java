import java.util.ArrayList;


public class Programmers_43164 {
    public static ArrayList<String> answer=new ArrayList<>();
    public static void main(String[] args) {
        solution(new String[][]{{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});
    
    }
    public static String[] solution(String[][] tickets) {
        ArrayList<Integer> checked=new ArrayList<>();
        dfs("ICN",checked,tickets,"");
        String smallest="";
        for(int i=0; i<tickets.length*3; i++)
        smallest+="Z";

        for(String s:answer){
            System.out.println(s);
            if(s.length()==tickets.length*3){
            if(s.compareTo(smallest)<0)
            smallest=s;
            }
        }
        ArrayList<String> new_answer=new ArrayList<>();
        new_answer.add("ICN");
        int temp=0;
        for(int i=0; i<smallest.length()/3; i++){
            new_answer.add(smallest.substring(temp, (i+1)*3));
            temp+=3;
            }
        String arr_answer[]=new_answer.toArray(new String[0]);
        for(String s: arr_answer)
        System.out.println(s);
        return arr_answer;
    }

    //ICN을 source로 줘서 ICN 이 0배열에 있는 걸 찾고 
    //CHECK하고 그 배열의 1도 CHECK하고 SOURCE로 줘서 반복 
    //마지막에 CHECK를 RETURN 더 없으면 RETURN 하게
    //모든 경우의 수를 다 찾아서
    //마지막에 리스트에 있는 알파벳 값중 가장 작은 걸 찾아야 한다.
    public static void dfs(String source, ArrayList<Integer> checked, String[][] tickets,String travel){

        String check_index="";
        if(travel.length()==tickets.length*3)
        answer.add(travel);

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(source)&& !checked.contains(i)){
                    check_index=Integer.toString(i);
                    checked.add(i);
                    travel+=tickets[i][1];
                    dfs(tickets[i][1],checked,tickets,travel); 
                    checked.remove(i);
                    if(travel.length()==3)
                    travel="";
                    else
                    travel.substring(0, travel.length()-3);
            }
        }
    }
    
        //무조건 길이까지 돈다음에 알파벳 순서를 찾는다.
        //마지막에 추가 된게 있으면 bfs를 실행시킨다.


        
}
