/**
 * Created by kaizh on 1/18/2017.
 */
public class MinimumPathOfBST {
    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public int minimumPath( TreeNode root){
        if(root == null)
                return 0;
        else if(root.left == null)
                return root.val + minimumPath(root.right);
        else if(root.right == null)
                return root.val + minimumPath(root.left);
        else
                return root.val + Math.min(minimumPath(root.left),minimumPath(root.right));

    }
}
