import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;
}
public class Main {

    public static List<List<Integer>> binaryTreeDepthOrder(
            BinaryTreeNode <Integer> tree) {
        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
        currDepthNodes.add(tree);
        List<List<Integer>> result = new ArrayList <>();
        while (!currDepthNodes.isEmpty()){
            Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
            List<Integer> thisLevel = new ArrayList<>();
            while (!currDepthNodes.isEmpty()){
                BinaryTreeNode <Integer> curr = currDepthNodes.poll();
                if (curr != null) {
                    thisLevel.add(curr.data);
// Defer the null checks to the null test above.
                    nextDepthNodes.add(curr.left);
                    nextDepthNodes.add(curr.right);
                }
            }
            if (!thisLevel.isEmpty()){
                result.add(thisLevel);
            }
            currDepthNodes = nextDepthNodes;
        }
        return result ;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> my_Tree = new BinaryTreeNode<Integer>();
        my_Tree.data = 314;
        my_Tree.left = new BinaryTreeNode<Integer>();
        my_Tree.left.data = 6;

        my_Tree.right = new BinaryTreeNode<Integer>();
        my_Tree.right.data = 6;

        my_Tree.left.left = new BinaryTreeNode<Integer>();
        my_Tree.left.left.data = 271;
        my_Tree.left.left.left = new BinaryTreeNode<Integer>();
        my_Tree.left.left.left.data = 28;
        my_Tree.left.left.right = new BinaryTreeNode<Integer>();
        my_Tree.left.left.right.data = 0;

        my_Tree.left.right = new BinaryTreeNode<Integer>();
        my_Tree.left.right.data = 561;
        my_Tree.left.right.right = new BinaryTreeNode<Integer>();
        my_Tree.left.right.right.data = 3;
        my_Tree.left.right.right.left = new BinaryTreeNode<Integer>();
        my_Tree.left.right.right.left.data = 17;

        my_Tree.right.left = new BinaryTreeNode<Integer>();
        my_Tree.right.left.data = 2;
        my_Tree.right.left.right = new BinaryTreeNode<Integer>();
        my_Tree.right.left.right.data = 1;
        my_Tree.right.left.right.left = new BinaryTreeNode<Integer>();
        my_Tree.right.left.right.left.data = 401;
        my_Tree.right.left.right.right = new BinaryTreeNode<Integer>();
        my_Tree.right.left.right.right.data = 257;
        my_Tree.right.left.right.left.right = new BinaryTreeNode<Integer>();
        my_Tree.right.left.right.left.right.data = 641;

        my_Tree.right.right = new BinaryTreeNode<Integer>();
        my_Tree.right.right.data = 271;

        my_Tree.right.right.right = new BinaryTreeNode<Integer>();
        my_Tree.right.right.right.data = 28;
        List<List<Integer>> result = binaryTreeDepthOrder(my_Tree);

        System.out.println(result);
    }
}