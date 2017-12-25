import java.util.HashSet;

/**
 * Created by kaizh on 1/4/2017.
 */
public class Bipartite {
    public boolean isBipartite(Node root){
        HashSet<Node> leftSet = new HashSet<>();
        HashSet<Node> rightSet = new HashSet<>();
        if(root == null)
            return true;
        return dfs(root,leftSet,rightSet);
    }
    public boolean dfs(Node root, HashSet<Node> leftSet, HashSet<Node> rightSet){
        if(rightSet.contains(root))
                return false;
        if(leftSet.contains(root))
                return true;
        leftSet.add(root);
        for(Node node : root.neighbors){
            if(!dfs(node,rightSet,leftSet))
                return false;
        }
        return true;
    }
}
