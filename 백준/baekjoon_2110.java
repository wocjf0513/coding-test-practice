import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.FutureTask;

public class baekjoon_2110 {

    /*
    도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

    도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
    C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

    입력
    첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

    출력
    첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
    */

    static ArrayList<Integer> points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pointN= Integer.parseInt(st.nextToken());
        int wifiN= Integer.parseInt(st.nextToken());

        points = new ArrayList<>();

        for (int i = 0; i < pointN; i++) {
            points.add(pointN);
        }

        Collections.sort(points);



    }
    public void setWifi() {

    }
    public int whatIdxMiddlePoint(int startIdx, int endIdx) {
        int valueWillNotMid = calculateNotWillMidValue(startIdx, endIdx, startIdx+endIdx/2);

        return valueWillNotMid;
    }
    public int calculateNotWillMidValue(int startIdx, int endIdx, int midIdx) {
        return Math.max(points.get(midIdx) - points.get(startIdx), points.get(endIdx) - points.get(midIdx));
    }

}
