import java.util.Deque;
import java.util.LinkedList;

public class 프렌즈4블록 {

    class Point{
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public boolean isValid(Point p) {
            return y < p.y && x < p.x;
        }
    }
    int m, n;
    char[][] board;
    public int solution(int m, int n, String[] board) {
        this.m= m;
        this.n= n;
        makeBoard(board);
        return boardGame();
    }
    public void makeBoard(String[] board){
        this.board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.board[i][j] = board[i].charAt(j);
            }
        }
    }
    public int boardGame() {
        int deletedAllBlocks = 0;
        while(true) {
            int deletedBlocks = deleteBlocks();
            if(deletedBlocks == 0) {
                break;
            } else {
                deletedAllBlocks += deletedBlocks;
                fallingDownBoard();
            }
        }
        return deletedAllBlocks;
    }
    public int deleteBlocks() {
        int deletedBlocks = 0;
        Deque<Point> pointsToDelete = new LinkedList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(board[i][j] == board[i][j + 1]
                    && board[i][j] == board[i + 1][j]
                    && board[i][j] == board[i + 1][j+1]) {
                    pointsToDelete.add(new Point(i, j));
                }
            }
        }

        while(!pointsToDelete.isEmpty()) {
            Point pointToDelete = pointsToDelete.poll();
            deletedBlocks += delete4x4Block(pointToDelete);
        }

        return deletedBlocks;
    }
    public int delete4x4Block(Point p) {
        int deletedBlocks = 0;

        if(board[p.y][p.x] != '0'){
            board[p.y][p.x] ='0';
            deletedBlocks ++;
        }
        if(board[p.y + 1][p.x] != '0'){
            board[p.y + 1][p.x] = '0';
            deletedBlocks ++;
        }
        if(board[p.y][p.x + 1] != '0'){
            board[p.y][p.x + 1] = '0';
            deletedBlocks ++;
        }
        if(board[p.y + 1][p.x + 1] != '0'){
            board[p.y + 1][p.x + 1] = '0';
            deletedBlocks ++;
        }

        return deletedBlocks;
    }
    public void fallingDownBoard() {
        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                Point movePoint = fallDown(new Point(y,x),new Point(y+1, x));
                char temp = board[movePoint.y][movePoint.x] ;
                board[movePoint.y][movePoint.x] = board[y][x];
                board[y][x] = temp;
            }
        }
    }
    public Point fallDown(Point lastPoint, Point curPoint) {
        if(curPoint.y >= m) {
            return lastPoint;
        } else {
            if(board[curPoint.y][curPoint.x] == '0'){
                lastPoint = curPoint;
                return fallDown(lastPoint, new Point(curPoint.y + 1, curPoint.x));
            } else {
                return lastPoint;
            }
        }
    }

}
