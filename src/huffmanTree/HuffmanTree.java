package huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root=createHuffmanTree(arr);
        root.preOrder();

    }

    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value: arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode=nodes.get(0);
            Node rightNode=nodes.get(1);
            Node parent=new Node(leftNode.value+ rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }
        return nodes.get(0);
    }

}
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{value="+value+"}";
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}