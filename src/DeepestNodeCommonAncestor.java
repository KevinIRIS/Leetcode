/**
 * Created by kaizh on 12/15/2016.
 */


import java.util.*;
class TreeNode1{
    int val;
    List<TreeNode1> adj;
    public TreeNode1(int val){
        this.val = val;
        adj = new ArrayList<>();
    }
}
class Result{
    TreeNode1 node;
    int depth;
    public Result(TreeNode1 node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
public class DeepestNodeCommonAncestor {
//     public static Result dfs (TreeNode1 root){
//         if(root.adj.size() == 0){
//             return new Result(null,1);
//         }
//         int maxDepth = 0;
//         Result res = new Result(root,maxDepth);
//         for(TreeNode1 neighbor : root.adj){
//             Result temp = dfs(neighbor);
//             if(temp.depth > maxDepth) {
//                 maxDepth = temp.depth;
//                 if(temp.node == null)
//                     res.node = root;
//                 else
//                    res.node = temp.node;
//                 res.depth = maxDepth;
//             }else if(temp.depth == maxDepth){
//                 res.node = root;
//             }
//         }
//         res.depth = maxDepth + 1;
//         return res;
//    }
    public static Result dfs(TreeNode1 root){
        if( root.adj.size() == 0)
            return new Result(null,0);
        Result res = new Result(root,0);
        int max = 0;  // max depth
        for(TreeNode1 i : root.adj){
            Result temp = dfs(i);
            if(temp.depth > max){
                if(temp.node == null)
                    res.node = root;
                else
                    res.node = temp.node;
                max = temp.depth;
            }else if(temp.depth == max)
                res.node = root;
        }
        res.depth = max + 1;
        return res;
    }
    public static void main(String[] args) {
//        TreeNode1 n1 = new TreeNode1(1);
//        TreeNode1 n2 = new TreeNode1(2);
//        TreeNode1 n3 = new TreeNode1(3);
//        TreeNode1 n4 = new TreeNode1(4);
//        TreeNode1 n5 = new TreeNode1(5);
//        TreeNode1 n6 = new TreeNode1(6);
//        TreeNode1 n7 = new TreeNode1(7);
//        TreeNode1 n8 = new TreeNode1(8);
//        TreeNode1 n9 = new TreeNode1(9);
//        TreeNode1 n10 = new TreeNode1(10);
//        n1.adj.add(n2);
//        n1.adj.add(n3);
//        n1.adj.add(n4);
//        n2.adj.add(n5);
//        n2.adj.add(n6);
//        n4.adj.add(n7);
//        n5.adj.add(n8);
//        n5.adj.add(n9);
//        n6.adj.add(n10);
//        System.out.print(dfs(n1).node.val);
        System.out.print("x"+"".split("#")[0] +"x");
    }
}
