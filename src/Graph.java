import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by naiveCode on 11/12/15.
 */
public class Graph {
    private int numOfVertices;
    private LinkedList<Integer>[] adj_list;

    Graph(int v) {
        numOfVertices = v;
        adj_list = new LinkedList[v];
        for (int i = 0; i < numOfVertices; i++) {
            adj_list[i] = new LinkedList<>();
        }
    }

    private void add_edge(int src, int dest) {
        adj_list[src].add(dest);
    }

    private void BFS(int source) {
        boolean[] visited = new boolean[numOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!visited[curr]) {
                System.out.print(" -> " + curr);
                LinkedList<Integer> l = adj_list[curr];
                for (Integer a : l) {
                    if (!visited[a]) {
                        queue.add(a);
                    }
                }
                visited[curr] = true;
            }
        }
    }
    private void DFS(int source){
        boolean[] visited = new boolean[numOfVertices];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(source);
        while (!stack.isEmpty()){
            int curr = stack.poll();

        }


    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.add_edge(0,1);
        g.add_edge(1,0);
//        g.add_edge(0,2);
        g.add_edge(1,2);
        g.add_edge(0,3);
        g.add_edge(0,4);
        g.BFS(0);
        System.out.println();
        g.BFS(1);

    }
}
