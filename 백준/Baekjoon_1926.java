import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon_1926 {

    static int[] dir = {1, -1, 0, 0};
    static int row, col;

    static boolean[][] checkPictures;
    static boolean[][] pictures;
    record Point(int row, int col){}
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        pictures = new boolean[row][col];
        checkPictures = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                pictures[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int maxArea = 0;
        int numberOfPicutres = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(pictures[i][j] && !checkPictures[i][j]) {
                    numberOfPicutres ++;
                    maxArea = Math.max(bfs(i,j), maxArea);
                }
            }
        }

        System.out.print(numberOfPicutres+"\n"+maxArea);

    }
    public static int bfs(int rowIdx, int colIdx) {
        int area = 0;
        Deque<Point> dq = new LinkedList<>();

        checkPictures[rowIdx][colIdx] = true;
        dq.add(new Point(rowIdx, colIdx));
        area++;

        while (!dq.isEmpty()) {
            Point curPoint = dq.pop();
            for (int i = 0; i < 4; i++) {
                Point pointToMove = new Point(curPoint.row + dir[i], curPoint.col + dir[3-i]);
                if(isAvailablePoint(pointToMove) && pictures[pointToMove.row][pointToMove.col] && !checkPictures[pointToMove.row][pointToMove.col]) {
                    checkPictures[pointToMove.row][pointToMove.col] = true;
                    dq.add(pointToMove);
                    area ++;
                }
            }
        }

        return area;
    }

    private static boolean isAvailablePoint(Point point) {
        if (0 <= point.row && 0 <= point.col && point.row < row && point.col< col) {
            return true;
        }
        return  false;
    }

}
