//Define the tree
public class Bst {
    Node root;
    Bst(){
        root = null;
    }

    /**
     * n is the new node you want to insert.
     * x is the current node you are visiting.
     * p records the parent of x
     * @param key
     */
    void insert(int key){
        Node n = new Node(key);
        Node x = root;//start form new
        Node y = null;
        //it will not be executed when tree is empty
        //determine which one is the parent node
        while (x != null){
            y = x;
            if(key < x.key){
                x = x.left;
            } else{
                x = x.right;
            }
        }
        n.parent = y;
        //parent node's left subtree conected with new node
        if(y == null){
            root = n;//tree was empty
        } else if(key < y.key){
            y.left = n;//parent node's left subtree conected with new node
        } else {
            y.right = n;
        }
    }

    /**
     *  inorder traversal order
     *  Left → Root → Right
     *  The output will be in sorted order.
     */
    void inorder(Node x){
        if(x != null){
            inorder(x.left);
            System.out.println(x.key);
            inorder(x.right);
        }
    }

    /**
     *  Pre-order Traversal
     *  Root → Left → Right
     */
    void preorder(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            preorder(x.left);
            preorder(x.right);
        }
    }
    /**
     *  Post-order Traversal
     *   Left → Right -> Root
     */
    void postorder(Node x) {
        if (x != null) {
            preorder(x.left);
            preorder(x.right);
            System.out.print(x.key + " ");
        }
    }
    Node treeMinimum(Node x){
        if( x == null) return null;
        while(x.left != null){
            x = x.left;
        }
        return x;
    }
    Node treeMaximum(Node x){
        if(x == null) return null;
        while (x.right != null){
            x = x.right;
        }
        return x;
    }
    /**
     *  Successor
     *  the node that comes immediately after the current node in inorder traversal.
     *  在中序遍历里，当前节点后面紧跟着的那个节点。
     *  The successor is the “next larger key.”
     *
     *  case 1:有右子树 - 右子树里最小的节点
     *  case 2:没有右子树 - 那就往上找父节点 - 一直往上 - 当前节点是在某个祖先的左边
     *  case 3: 如果一路往上都没有找到，说明它已经是最大值，没有 successor
     *
     *         20
     *        /  \
     *       10   30
     *      /  \
     *     5    15
     *         /
     *        12
     *
     *  10 有右子树 successor is 12
     *  15 no right subtree, syccessor is 20
     *  30 no successor
     *
     */
    Node treeSuccessor(Node x){
        if(x == null) return null;

        // 情况1：有右子树 | Case 1: has right subtree
        if(x.right != null){
            return treeMinimum(x.right);
        }
        // 情况2：没有右子树，往上找 | Case 2: no right subtree, move upward
        Node y = x.parent;
        while(y != null && x == y.right){
            x = y ;
            y = y.parent;//parent de parent
        }
        return y;
    }

    /**
     * predecessor
     *
     * 左子树中数值最大的节点（即左子树最右侧的节点）。
     *
     * case 1 : exist left_subtree, find the maximum number of left_subtree
     * case 2 : 向上回溯, it must satisfy input_node is right_child of parent_node
     *          20
     *        /  \
     *       10   30
     *      /  \    \
     *     5    15   35
     *      \
     *       8
     *
     * 10 有左子树, predecessor is 8
     * 15 向上回溯, predecessor is 10 - According to the judgment, 15 is the right_child of 15
     * 5 no left-subtree, 向上回溯：5 是 10 的左孩子, 向上回溯：10 是 20 的左孩子,已经到根节点了。
     * @param x
     * @return
     */
    public Node treePredecessor(Node x){
        if(x.left != null){
            return treeMaximum(x.left);
        }
        Node y = x.parent;
        while (y != null && x == y.left){
            x = y;
            y = y.parent;//until y == root - termination
        }
        return y;
    }


}
