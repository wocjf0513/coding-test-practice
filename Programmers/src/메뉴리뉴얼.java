import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class 메뉴리뉴얼 {

    HashSet<String> combs = new HashSet<>();
    ArrayList<String> combList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            combList = new ArrayList<>();
            for (int j = 0; j < orders.length; j++) {
                makeComb(orders[j].toCharArray(), course[i], 0, new StringBuilder());
            }
            answer.addAll(bestComb(orders));
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }
    public void makeComb(char[] order, int course, int curIdx, StringBuilder sb) {
        if(sb.length() == course) {
            String sortedComb = sort(sb);
            if(!combs.contains(sortedComb)){
                combs.add(sortedComb);
                combList.add(sortedComb);
            }
            return;
        }

        for (int i = curIdx; i < order.length; i++) {
            sb.append(order[i]);
            makeComb(order, course, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private String sort(StringBuilder sb) {
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);

        StringBuilder answer = new StringBuilder();
        answer.append(chars);

        return answer.toString();
    }
    public List<String> bestComb(String[] orders) {
        List<String> answer = new ArrayList<>();

        class Comb {
            String comb;
            int existNum;

            Comb(String c, int n) {
                comb = c;
                existNum =n;
            }
        }

        PriorityQueue<Comb> combList = new PriorityQueue<>((o1, o2) -> {
            return o2.existNum - o1.existNum;
        });

        for (int i = 0; i < this.combList.size(); i++) {
            int orderNumHasComb = 0;
            for (int j = 0; j < orders.length; j++) {
                if(hasCombInOrder(this.combList.get(i), orders[j])) {
                    orderNumHasComb ++;
                }
            }
            combList.add(new Comb(this.combList.get(i), orderNumHasComb));
        }

        int maxExistCombNum = 0;

        while(!combList.isEmpty()) {
            Comb comb= combList.poll();

            if(maxExistCombNum > comb.existNum || comb.existNum < 2){
                break;
            } else {
                maxExistCombNum = comb.existNum;
                answer.add(comb.comb);
            }
        }

        return answer;
    }
    public boolean hasCombInOrder(String comb, String order) {
        boolean hasComb = false;
        for(char c: comb.toCharArray()) {
            hasComb = order.contains(c+"");
            if(!hasComb) {
                break;
            }
        }

        return hasComb;

    }

}
