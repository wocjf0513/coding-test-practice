import java.util.Arrays;
import java.util.PriorityQueue;

public class 셔틀버스 {

    String startTime = "09:00";

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);

        int lastShuttleBus = n * t - t + toIntMinute(startTime);

            int startMinute = toIntMinute(startTime);
            int passenger = 0;
            int lastWaiterMinute = 0;
            for (int i = 0; i < timetable.length; i++) {
                int waiterMinute = toIntMinute(timetable[i]);
                if(waiterMinute <= startMinute) {
                    passenger++;
                    if(passenger == m) {
                        startMinute =+ t;
                        if(startMinute == lastShuttleBus) {
                            lastWaiterMinute = waiterMinute;
                            break;
                        }
                    }
                } else {
                    startMinute =+ t;
                }
            }

            if(lastWaiterMinute !=0) {
                return toStrTime(lastWaiterMinute-1);
            } else {
                return toStrTime(lastShuttleBus);
            }
    }

    public int toIntMinute(String time) {
        String[] timeInfo =time.split(":");

        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }
    public String toStrTime(int commingMinute) {
        int hour = commingMinute/60;
        int minute = commingMinute % 60;

        return (hour < 10? "0"+hour : hour) + ":" + (minute < 10? "0"+ minute : minute);
    }

}
