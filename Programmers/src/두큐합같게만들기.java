import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    class Solution {
        long oneQueueSum = 0;
        long twoQueueSum = 0;
        public long solution(int[] queue1, int[] queue2) {
            Queue<Integer> oneQueue = new LinkedList<>();
            Queue<Integer> twoQueue = new LinkedList<>();

            Arrays.stream(queue1).forEach(i -> {
                oneQueue.add(i);
                oneQueueSum += i;
            });
            Arrays.stream(queue2).forEach(i -> {
                twoQueue.add(i);
                twoQueueSum += i;
            });

            if((oneQueueSum + twoQueueSum) % 2 == 0) {
                return -1;
            }

            long count = 0;

            long halfSum = (oneQueueSum + twoQueueSum) / 2;

            while(count < queue1.length) {
                if(count >= queue1.length) {
                    count = -1;
                    break;
                }
                if(halfSum == oneQueueSum) {
                    break;
                }
                if(halfSum < oneQueueSum) {
                    int pullNum = oneQueue.poll();
                    twoQueue.add(pullNum);
                    twoQueueSum += pullNum;
                    oneQueueSum -= pullNum;
                } else {
                    int pullNum = twoQueue.poll();
                    oneQueue.add(pullNum);
                    oneQueueSum += pullNum;
                    twoQueueSum -= pullNum;
                }

                count ++;
            }

            return count;

        }
    }

}
