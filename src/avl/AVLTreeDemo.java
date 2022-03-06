package avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8

    }
}
class AVLTree{
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
    //计算左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    //计算右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }
    //计算树的高度
    public int height() {
        return Math.max(left==null?0: left.height(), right==null?0: right.height())+1;
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
        //添加完调整
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
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
    public void leftRotate() {
        Node newNode=new Node(this.value);
        newNode.left=left;
        newNode.right=right.left;
        value=right.value;
        left=newNode;
        right=right.right;
    }

    public void rightRotate() {
        Node newNode=new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        right=newNode;
        left=left.left;
    }
}

