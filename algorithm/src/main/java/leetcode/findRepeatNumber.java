package leetcode;

import java.util.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/20 13:53
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class findRepeatNumber {

    private volatile int a;

    public static Node solve(Node root){
        if(root==null) {
            return null;
        }
        Node leftNode = solve(root.left);
        if(leftNode!=null) {
            leftNode.right = root;
            System.out.println(leftNode.val);
        }
        root.left = leftNode;
        Node rightNode = solve(root.right);
        root.right = rightNode;
        if(rightNode!=null) {
            rightNode.left = root;
            System.out.println(rightNode.val);
        }
        Node result = root;
        while(result!=null && result.left!=null) {
            result = result.left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

//实现Comparator接口
class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
    		        /*如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，
    		         这样颠倒一下，就可以实现降序排序了,反之即可自定义升序排序了*/
        return o2-o1;
    }

}
