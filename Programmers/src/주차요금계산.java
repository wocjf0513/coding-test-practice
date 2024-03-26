import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 주차요금계산 {
    Set<Integer> carNumbers = new HashSet<Integer>();
    HashMap<Integer, Integer> commingTimeByCar = new HashMap<>();
    HashMap<Integer, Integer> parkingTimeByCar = new HashMap<>();
    String MAX_TIME = "23:59";
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;

        for(String record : records) {
            st = new StringTokenizer(record);
            String time = st.nextToken();
            int carNumber = Integer.parseInt(st.nextToken());
            String status = st.nextToken();

            if(status.equals("IN")) {
                carNumbers.add(carNumber);
                commingTimeByCar.put(carNumber, transferToTimeMinute(time));
            } else {
                int parkingTime = transferToTimeMinute(time) - commingTimeByCar.get(carNumber);
                commingTimeByCar.remove(carNumber);
                parkingTimeByCar.put(carNumber,parkingTimeByCar.getOrDefault(carNumber,0) + parkingTime);
            }
        }

        carNumbers.stream().forEach(carNumber -> {
            if(commingTimeByCar.containsKey(carNumber)){
                int parkingTime = transferToTimeMinute(MAX_TIME) - commingTimeByCar.get(carNumber);
                commingTimeByCar.remove(carNumber);
                parkingTimeByCar.put(carNumber,parkingTimeByCar.getOrDefault(carNumber,0) + parkingTime);
            }
        });

        carNumbers.stream().forEach(carNumber -> {
            System.out.println(parkingTimeByCar.get(carNumber));
        });


        return setteleTheParkingCost(fees);
    }
    public int[] setteleTheParkingCost(int[] fees) {
        ArrayList<Integer> parkingCost = new ArrayList<>();
        carNumbers.stream().sorted().forEach(carNumber -> {
            int parkingTime = parkingTimeByCar.getOrDefault(carNumber, 0);
            if(parkingTime <= fees[0]) {
                parkingCost.add(fees[1]);
            } else {
                int overTime = parkingTime - fees[0];
                int overTimeCost = (int) Math.ceil((double)overTime / fees[2]) *  fees[3];
                parkingCost.add(overTimeCost + fees[1]);
            }
        });

        return parkingCost.stream().mapToInt(Integer::intValue).toArray();
    }
    public int transferToTimeMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return hour * 60 + minute;
    }
}
