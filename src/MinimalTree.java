///**
// * Created by kaizh on 11/15/2016.
// */
//public class MinimalTree {
//    class TreeNode{
//        int val;
//        TreeNode left, right;
//        public TreeNode(int i){
//            this.val = i;
//        }
//    }
//    public TreeNode conMinTree(int[] array, int left, int right){
//        if(left > right )
//            return null;
//        int mid = left + (right - left) / 2;
//        TreeNode parent = new TreeNode(array[mid]);
//        parent.left = conMinTree(array, left, mid - 1);
//        parent.right = conMinTree(array, mid + 1, right);
//        return parent;
//    }
//    public static void main(String[] args){
//        int[] array = new int[10];
//        for(int i = 0; i < array.length; i++){
//            array[i] = i;
//        }
//        TreeNode root;
//        if(array == null || array.length ==0)
//                root = null;
//        MinimalTree sol = new MinimalTree();
//        root = sol.conMinTree(array,0,array.length - 1);
//    }
//}
