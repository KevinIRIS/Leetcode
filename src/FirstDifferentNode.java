/**
 * Created by kaizh on 12/16/2016.
 */
import javafx.collections.transformation.FilteredList;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FirstDifferentNode {
    List<TreeNode> inorder(TreeNode node1, TreeNode node2){
        List<TreeNode> res = new ArrayList<>();
        TreeNode curNode1 = node1, curNode2 = node2;
        TreeNode preNode1 = null, preNode2 = null;
        while(curNode1 != null ){
            if(curNode1.left == null ){
                if(curNode1.val != curNode2.val) {
                    res.add(curNode1);
                    res.add(curNode2);
                    break;
                }
                curNode1 = curNode1.right;
                curNode2 = curNode2.right;
            }else{
                preNode1 = curNode1.left;
                preNode2 = curNode2.left;
                while(preNode1.right != null && preNode1.right != curNode1){
                    preNode1 = preNode1.right;
                    preNode2 = preNode2.right;
                }
                if(preNode1.right == null){
                    preNode1.right = curNode1;
                    curNode1 = curNode1.left;
                    preNode2.right = curNode2;
                    curNode2 = curNode2.left;
                }else{
                    preNode1.right = null;   // recover the original tree structure
                    preNode2.right = null;
                    if(curNode1.val != curNode2.val) {
                        res.add(curNode1);
                        res.add(curNode2);
                        break;
                    }
                    curNode1 = curNode1.right;
                    curNode2 = curNode2.right;
                }
            }
        }
        return res;
    }
    List<TreeNode> inorderStack(TreeNode node1, TreeNode node2){
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode point1 = node1, point2 = node2;
        while(point1 != null){
            stack1.push(point1);
            stack2.push(point2);
            point1 = point1.left;
            point2 = point2.left;
        }
        while(!stack1.isEmpty()){
            point1 = stack1.pop();
            point2 = stack2.pop();
            if(point1.val != point2.val){
                res.add(point1);
                res.add(point2);
                break;
            }
            point1 = point1.right;
            point2 = point2.right;
            while(point1 != null){
                stack1.push(point1);
                stack2.push(point2);
                point1 = point1.left;
                point2 = point2.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);

        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);

        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(5);
        node1.left = node3;
        node3.right = node5;
        node5.left = node7;
        node5.right = node9;

        node2.left = node4;
        node4.right = node6;
        node6.left = node8;
        node6.right = node10;
        List<TreeNode> res = new FirstDifferentNode().inorderStack(node1,node2);
        for(TreeNode i : res)
            System.out.println(i.val);
    }
}
