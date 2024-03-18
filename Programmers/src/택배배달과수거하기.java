import java.util.*;
public class 택배배달과수거하기 {

    long drivingDist = 0;


        class DeliverOrPickup{
            int dist;
            int n;

            DeliverOrPickup(int dist, int n) {
                this.dist = dist;
                this.n = n;
            }
        }


        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            PriorityQueue<DeliverOrPickup> deliver = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);
            PriorityQueue<DeliverOrPickup> pickup = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);

            for (int i = 0; i < n; i++) {
                if(deliveries[i] != 0)
                deliver.add(new DeliverOrPickup(i+1, deliveries[i]));
                if(pickups[i] != 0)
                pickup.add(new DeliverOrPickup(i+1, pickups[i]));
            }

            while(true) {

                if(deliver.isEmpty() && pickup.isEmpty()) {
                    break;
                }

                takeBox(cap, deliver, pickup);
            }

            return drivingDist;

        }
        private void takeBox(int cap, PriorityQueue<DeliverOrPickup> deliver, PriorityQueue<DeliverOrPickup> pickup) {
            int dist = 0;

            dist = getDist(deliver, cap, dist);
            dist = getDist(pickup, cap, dist);

            drivingDist += dist * 2;
        }

    private int getDist(PriorityQueue<DeliverOrPickup> deliverOrPickup, int cap, int dist) {
        while(!deliverOrPickup.isEmpty()) {
            if(cap <= 0) {
                break;
            }

            DeliverOrPickup farthesetObject = deliverOrPickup.poll();
            dist = Math.max(dist, farthesetObject.dist);
            if(farthesetObject.n <= cap) {
                cap -= farthesetObject.n;
            } else {
                farthesetObject.n -= cap;
                deliverOrPickup.add(farthesetObject);
                cap = 0;
            }
        }
        return dist;
    }
}
