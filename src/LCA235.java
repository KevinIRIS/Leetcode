/**
 * Created by kaizh on 11/15/2016.
 */
public class LCA235 {
    public static void main(String[] args){

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        int dif = (p.val - root.val) * (q.val - root.val);
        if(dif <= 0)
            return root;
        else{
            if(p.val > root.val)
                return lowestCommonAncestor(root.right,p,q);
            else
                return lowestCommonAncestor(root.left,p,q);
        }
    }
    class TreeNode{
        int val;
      TreeNode left, right;
        public TreeNode(int i){
            this.val = i;
        }
    }
}
