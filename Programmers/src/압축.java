import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

    HashMap<String, Integer> dictionary = new HashMap<>();
    public int[] solution(String msg) {
        ArrayList<Integer> answers = new ArrayList<>();

        for(int i=1; i<=26; i++) {
            char alpha = (char)('A'+(i-1));
            dictionary.put(alpha+"", i);
        }

        StringBuilder sb = new StringBuilder();
        int idx= 27;
        int preIdx = 0;

        for (int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));

            if(dictionary.containsKey(sb.toString())) {
                preIdx = dictionary.get(sb.toString());
            } else {
                dictionary.put(sb.toString(), idx++);
                answers.add(preIdx);
                sb = new StringBuilder();
                i-=1;
            }
        }

        if(sb.length() != 0) {
            answers.add(preIdx);
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
