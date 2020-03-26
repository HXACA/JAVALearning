package leetcode;

import java.lang.reflect.Array;
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
        int[] a = {4,2,5,1,3};
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        Node node = solve(root);
        Node temp = node;
        while(temp !=null && temp.right!=null){
            temp = temp.right;
        }
        temp.right = node;
        node.left = temp;
        int index = 0;
        while(node.right!=null && index<10){
            System.out.println(node.val);
            node = node.right;
            index++;
        }
    }
}
