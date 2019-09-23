package leetcode.addtwonum;

/**
 * @ClassName leetcode.addtwonum.AddTwoNumbers
 * @Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author chenkq
 * @Date 2019/9/23 20:41
 * @Version V1.0
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node2.next  = node3;
        node1.next = node2;
        node5.next = node6;
        node4.next  = node5;
        long time1 = System.currentTimeMillis();
        ListNode node = addTwoNumbers1(node1,node4);
        long time2 = System.currentTimeMillis();
        ListNode node7 = addTwoNumbers2(node1,node4);
        long time3 = System.currentTimeMillis();
        System.out.println(time1+"            "+time2+"            "+time3);
        System.out.printf("方法1执行时间："+(time2-time1));
        System.out.printf("方法2执行时间："+(time3-time2));


    }
    /**
     * @Description //解法1：先将两个ListNode转成数字，相加后将结果转换成ListNode
     * @Date 2019/9/23 21:16
     * @Param
     * @return
     **/
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        int num1=0,num2 = 0;
        ListNode tempNode1 = l1;
        for (int i = 0;tempNode1!=null;i++){
            num1 = num1+tempNode1.val*(int)Math.pow(10,i);
            tempNode1 = tempNode1.next;
        }
        System.out.println("l1的值是：      "+num1);
        tempNode1 = l2;
        for (int i = 0;tempNode1!=null;i++){
            num2 = num2+tempNode1.val*(int)Math.pow(10,i);
            tempNode1 = tempNode1.next;
        }
        System.out.println("l2的值是：      "+num2);

        int num3 = num1+num2;
        ListNode lastNode = null;
        for (int i=0;getQuotient(num3,(int)Math.pow(10,i))>0;i++){

            ListNode tempNode = new ListNode(Math.floorMod(getQuotient(num3,(int)Math.pow(10,i)),10));
            if(i==0){
                firstNode= tempNode;
                lastNode = tempNode;
            }
            if(i!=0){
            lastNode.next = tempNode;
            lastNode = tempNode;
            }
        }
        return firstNode;
    }

    /**
     * @Description //解法2：跟据ListNode的深度直接计算当前位数的结果然后链接起来
     * @Date 2019/9/23 21:19
     * @Param
     * @return
     **/
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int i = 0;//层级
        boolean flag = false;//是否有进位
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode firstNode = null;
        ListNode lastNode = null;
        while (!(temp1==null && temp2==null && !flag)){
            ListNode tempNode = null;
            int val = 0;
            if(temp1 != null && temp2 != null ){
                if(flag){
                    val = temp1.val+temp2.val+1;
                }else{
                    val = temp1.val+temp2.val;
                }
            }
            if(temp1 == null && temp2 != null ){
                if(flag){
                    val = temp2.val+1;
                }else{
                    val = temp2.val;
                }
            }
            if(temp1 != null && temp2 == null ){
                if(flag){
                    val = temp1.val+1;
                }else{
                    val = temp1.val;
                }
            }
            if(temp1==null&&temp2==null&&flag){
                val = 1;
            }
        if(val>=10){
            flag = true;
            val  = val % 10;
        }else{
            flag = false;
        }
        tempNode =  new ListNode(val);
        if(i==0){
            firstNode = tempNode;
            lastNode = tempNode;
        }else{
            lastNode.next = tempNode;
            lastNode = tempNode;
        }

        if(temp1!=null) {
            temp1 = temp1.next;
        }
        if(temp2!=null) {
            temp2 = temp2.next;
        }
        i++;
        }


        return firstNode;
    }

    public static int getQuotient(int a,int b){
        return a/b;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
