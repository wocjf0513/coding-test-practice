import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {

    /*
     * 최소 스패닝 트리: 모든 정점을 연결하는 그래프 중 가중치가 최소인 그래프
     */

    /*
     * 정점 간선
     * 간선 정보 가중치*/

    static int[] parentByVertex;
    static class Edge {

        public Edge(int startVertex, int endVertex, int value) {
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.value = value;
        }

        int startVertex;
        int endVertex;
        int value;

        public int getStartVertex() {
            return startVertex;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        parentByVertex = new int[vertex + 1];

        for (int i = 1; i <= vertex; i++) {
            parentByVertex[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        int selectedEdgeCount = 0;

        while (selectedEdgeCount < vertex - 1) {
            Edge polledEdge = pq.poll();

            int startVertexParent = findHighestParent(polledEdge.startVertex);
            int endVertexParent = findHighestParent(polledEdge.endVertex);
            if(findHighestParent(startVertexParent) == findHighestParent(endVertexParent)) {
                continue;
            }

            int smallerVertexParent = Math.min(startVertexParent, endVertexParent);

            parentByVertex[startVertexParent] = smallerVertexParent;
            parentByVertex[endVertexParent] = smallerVertexParent;

            answer += polledEdge.value;
            selectedEdgeCount++;
        }

        System.out.println(answer);
    }
    public static int findHighestParent(int vertex) {
        if(vertex == parentByVertex[vertex]) {
            return vertex;
        } else {
            return parentByVertex[vertex] = findHighestParent(parentByVertex[vertex]);
        }
    }
}