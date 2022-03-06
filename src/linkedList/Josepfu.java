package linkedList;

public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }
}
//创建一个环形链表
class CircleSingleLinkedList{
    private Boy frist=null;
//    添加节点
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;//用于辅助建立环形链表
        for (int i = 1; i <=nums; i++) {
            Boy boy=new Boy(i);
            if (i==1){
                frist=boy;
                frist.setNext(frist);
                curBoy=frist;
            }else{
                curBoy.setNext(boy);
                boy.setNext(frist);
                curBoy=boy;
            }
        }
    }
//    遍历环形链表
    public void showBoy(){
        //判断是否为空
        if(frist==null){
            System.out.println("没有任何小孩！");
            return;
        }
        Boy curBoy=frist;
        while(true){
            System.out.println("小孩的编号为"+curBoy.getNo());
            if(curBoy.getNext()==frist){
                //遍历结束条件
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo//开始小孩编号
     * @param countNum//报数大小
     * @param nums//小孩总数
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(frist==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误！");
            return;
        }
        Boy curBoy=frist;//辅助指针确定现在的小孩编号
        //将指针移到起始编号
        for (int i = 0; i <startNo-1 ; i++) {
            curBoy=curBoy.getNext();
        }
        //循环出圈
        while(true){
            //只剩最后一个小孩
            if (curBoy.getNext()==curBoy){
                System.out.println("最后一个小孩编号为"+curBoy.getNo());
                break;
            }
            //找到出圈小孩的前一个
            for (int i = 0; i <countNum-2 ; i++) {
                curBoy=curBoy.getNext();
            }
            System.out.println("小孩"+curBoy.getNext().getNo()+"出圈");
            curBoy.setNext(curBoy.getNext().getNext());//小孩出圈
            curBoy=curBoy.getNext();//下一个小孩开始报数
        }
    }

}
//创建一个孩童节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
