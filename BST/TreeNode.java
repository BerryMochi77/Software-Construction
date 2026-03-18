import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }

    /** insert Binary Search Tree
    recursion structure
     */
    public TreeNode insert(TreeNode root, int val){
        //base case
        if(root == null) return new TreeNode(val);

        if(val < root.val) {
            root.left = insert(root.left , val);
        } else {
            root.right = insert(root.right , val);
        };
        return root;
    }
    public TreeNode insertIteration(TreeNode root, int val){
        TreeNode z = new TreeNode(val);

        if (root == null) return z;

        TreeNode x = root;
        TreeNode y = null;
        while(x != null){
            y = x;
            if(val < x.val){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        //last parent root z
        if(val < y.val){
            y.left = z;
        } else{
            y.right = z;
        }
        return root;
    }

    /** insert Binary Search Tree
     recursion structure
     */
    public boolean search(TreeNode root , int val){
        //base case
        if(root == null) return false;
        if(root.val == val) return true;

        if(val < root.val) return search(root.left,val);
        return search(root.right,val);
    }

    /**
     *  Traversal - Depth search binary tree
     *  1.preorder 2.inorder 3.postorder
     *
     *  平衡 → Average O(log n)
     *  不平衡 → Worst O(n)
     */

    /**
     *  preorder
     * root -> left -> right
     */
    public void preorder(TreeNode root){
        if(root == null) return;

        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    /**
     * Inorder
     * left -> root -> right
     */
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }
    /**
     * postorder
     *  left -> right -> root
     */
    public void postorder(TreeNode root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val + " ");
    }

    /**
     *  BFS - level order
     *  Queue - a type of linkedlist , first in first out
     */
    public void bfsSearch(TreeNode root){
        if(root == null ) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val + " ");

            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
    /**
     *   notification : 需要 parent 指针
     *   Predecessor : 小的最大值
     *   case 1 : if there is left subtree, find the maximum to left subtree
     *   case 2: otherwise, go upward until you find an ancestor(parent node) where the current node is in its right side.
     *   Successor: 大的最小值
     *   case 1: if there is right subtree, find the minimum to the right subtree.
     *   case 2. otherwise, go upward until you find an ancestor where the current node is in its right side.
     */

    /**
     *  maximum and minimum
     *  base on the order tree.
     */
    public TreeNode findMax(TreeNode root){
        if (root == null) return null;
         while(root.right != null){
             root = root.right;
         }
         return root;
    }
    public TreeNode findMin(TreeNode root){
        if (root == null) return null;
        while(root.left != null ){
            root = root.left;
        }
        return root;
    }

    /**
     * 直接给你节点本身,不需要查找，直接从这个节点出发找后继。
     * 找到node x 里比key【x】大的最小值，从树里，然后直接返回那个节点。
     * @param x
     * @return
     */
    public TreeNode prdecessor(TreeNode x){
        if(x == null) return null;
        //case 1 -exits right-subtree
        if(x.left != null ){
            return findMax(x.left);
        }
        //case 2 no left subtree, go upward
        //TreeNode y = x.
        return null;
    }
    /**
     *  没有指针的，就要从 root 开始往下找，边走边记录"最近一次向右转的节点"。
     */

    public TreeNode predecessor(TreeNode root,TreeNode x){
        return null;
    }
}
