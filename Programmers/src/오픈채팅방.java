import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {
    class Solution {


        HashMap<String , String> nickNameMap = new HashMap<>();

        public String[] solution(String[] record) {

            ArrayList<String> result = new ArrayList<>();

            Arrays.stream(record).forEach(str->{
                if(str.startsWith("Enter") || str.startsWith("Change")) {
                    String[] parsedOrder = str.split(" ");
                    nickNameMap.put(parsedOrder[1], parsedOrder[2]);
                }
            });

            Arrays.stream(record).forEach(str->{
                if(str.startsWith("Enter")) {
                    String[] parsedOrder = str.split(" ");
                } else if(str.startsWith("Leave")) {
                    String[] parsedOrder = str.split(" ");
                    result.add(nickNameMap.get(parsedOrder[1])+"님이 나갔습니다.");
                }
            });

            return result.toArray(new String[0]);
        }
    }
}
