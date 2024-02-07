import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 알파벳 {

    /*
    * 세로 R칸, 가로 C칸
    * 좌측 상단 칸에 말
    *
    * 새로 이동한 칸에 적혀있는 알파벳은 지금까지 지나온 모든 칸과 달라야 한다.
    *
    * 최대한 몇 칸 지날 수 있는지? (좌측 상단 칸 포함)
    * */
    static int[][] board;
    static int y,x;
    static int maxDeep = 1;
    static int[] dir = {0,0,-1,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        y= Integer.parseInt(st.nextToken());
        x= Integer.parseInt(st.nextToken());
        board = new int[y+1][x+1];

        for (int i = 1; i <= y; i++) {
            String inputAlphabat = br.readLine();
            for (int j = 1; j <= x; j++) {
                board[i][j] = inputAlphabat.charAt(j-1) - 'A';
            }
        }

        boolean[] checkAlphabat = new boolean[100];
        checkAlphabat[board[1][1]] = true;

        dfs(checkAlphabat, 1, 1, 1);
        System.out.println(maxDeep);
    }
    private static void dfs(boolean[] checkAlphabat, int curY, int curX, int deep) {

        if(deep > maxDeep) {
            maxDeep = deep;
        }

        for (int i = 0; i < 4; i++) {
            int yToMove = curY + dir[i];
            int xToMove = curX + dir[3-i];

            if(isAvailablePoint(yToMove, xToMove) && !checkAlphabat[board[yToMove][xToMove]]) {
                checkAlphabat[board[yToMove][xToMove]] = true;
                dfs(checkAlphabat, yToMove, xToMove, deep+1);
                checkAlphabat[board[yToMove][xToMove]] = false;
            }
        }
    }
    private static boolean isAvailablePoint(int curY, int curX) {
        return 1<= curX && curX <=x && 1<=curY && curY<=y;
    }
}