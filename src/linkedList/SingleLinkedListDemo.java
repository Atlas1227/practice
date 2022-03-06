package linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

//        // 测试一下单链表的反转功能
//        System.out.println("原来链表的情况~~");
//        singleLinkedList.list();
        //加入按照编号的顺序
//        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);

        //显示一把
        singleLinkedList.list();
    }

}
//定义单向链表
class SingleLinkedList{
    private HeroNode head=new HeroNode(0, "", "");
//返回头节点
    public HeroNode getHead() {
        return head;
    }
//    添加节点
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    //按顺序添加节点
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp=head;
        boolean flag=false;//用于判断插入节点是否存在
        while(true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }else if(temp.next.no== heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.printf("准备添加的节点%d已经存在了，不能添加\n",heroNode.no);
        }else{

            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
//    根据节点编号修改节点信息
    public void update(HeroNode heroNode){
//        判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=false;//表示是否找到相应节点
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name= heroNode.name;
            temp.nickname= heroNode.nickname;
        }else{
            System.out.printf("未找到编号为%d的节点，不能修改\n",heroNode.no);
        }
    }
//    删除节点（占到对应节点的前一个，然后删除）
    public void del(int no){
//        判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp=head;
        boolean flag=false;//判断是否找到相应节点前一个
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("未找到要删除的节点");
        }
    }
//    遍历链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp=head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

//创建节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=" + name +
                ", nickname=" + nickname +
                '}';
    }
}
