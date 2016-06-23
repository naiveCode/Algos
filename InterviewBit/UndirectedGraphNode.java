import java.util.ArrayList;
import java.util.List;

/**
 * Created by naiveCode on 16/6/16.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
