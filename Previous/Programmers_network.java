import java.util.*;

public class Programmers_network {

    static int answer;
    static boolean[] visited={false,false,false};
    public static void main (String args[]){
        bfs(3,0,new int[][]{{1,1,0},{1,1,1},{0,1,1}},visited);
        System.out.println(answer);
    }
    public static void bfs(int n,int v, int[][] numbers, boolean[] visited) {
        //bfs를 시작 que에 넣으면서.. bfs를 한 후 que에 없는 친구를
        //bfs하는 걸 반복
        //이렇게 해서 개수를 센다?
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            v=queue.poll();
            visited[v]=true;
            for(int i=0; i<n; i++){
                if(numbers[v][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        answer++;
        for(int i=0; i<n; i++){
            if(visited[i]==false)
            bfs(n, i, numbers, visited);
        }
    }
}
