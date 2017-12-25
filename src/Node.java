import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaizh on 1/7/2017.
 */
 class Node {
    public Node() {
        neighbors = new HashSet<Node>();
    }
    Set<Node> neighbors;
}
