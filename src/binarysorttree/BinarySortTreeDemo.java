package binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(7);


        System.out.println("root=" + binarySortTree.getRoot());


        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }

}
class BinarySortTree{
    private Node root;

    public Node getRoot() {
        return root;
    }
    public void add(Node node){
        if (root==null){
            root=node;
        }else{
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else{
            System.out.println("二叉树为空，不能遍历");
        }
    }
    public Node search(int value){
        if(root==null){
            return null;
        }else{
            return root.search(value);
        }
    }
    public Node searchParent(int value){
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node) {
        Node target=node;//辅助指针
        while (target.left!=null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;

    }
    public void delNode(int value){
        if (root == null) {
            return;
        } else {
            //找到目标节点
            Node targetNode=search(value);
            if (targetNode==null){
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent=searchParent(value);
            //目标节点是叶子节点的情况下
            if (targetNode.left == null && targetNode.right == null) {
                //判断目标节点是父节点的左节点还是右节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right=null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//目标节点左右子节点都存在
                int minVal=delRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            } else {//删除只有一个子节点的
                if (targetNode.left != null) {
                    if (parent!=null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root=targetNode.left;
                    }
                } else {
                    if (parent!=null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root=targetNode.right;
                    }
                }
            }
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node={value="+value+"}";
    }
    public void add(Node node){
        if (node==null){
            return;
        }
        if(node.value<this.value){
            if (this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    public Node search(int value){
        if (value==this.value){
            return this;
        }else if (value<this.value){
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        }else{
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }
    public Node searchParent(int value){
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else{
            if (value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else{
                return null;//没有父节点
            }
        }
    }
}
