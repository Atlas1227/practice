package linkedList;

import java.util.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
/*        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();*/
        //加入按照编号的顺序
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);

        //显示一把
        doubleLinkedList.list();
    }
}
//定义双向链表
class DoubleLinkedList{
    private HeroNode2 head=new HeroNode2(0, "", "");
    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }
    //    添加节点
    public void add(HeroNode2 heroNode){
        HeroNode2 temp=head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    //按顺序添加节点
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp=head;
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
            if (temp.next!=null) {
                temp.next.pre=heroNode;
            }
            temp.next=heroNode;
            heroNode.pre=temp;
        }
    }
    //    根据节点编号修改节点信息
    public void update(HeroNode2 heroNode){
//        判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode2 temp=head.next;
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
        HeroNode2 temp=head.next;
        boolean flag=false;//判断是否找到相应节点前一个
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            //temp为最后一个节点时，会报空指针
            if (temp.next!=null) {
                temp.next.pre=temp.pre;
            }
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
        HeroNode2 temp=head.next;
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
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name=" + name +
                ", nickname=" + nickname +
                '}';
    }
}
