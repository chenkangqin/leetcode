package offer.replacespace;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName offer.replacespace.ReverseLinkleNode
 * @Description 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author chenkq
 * @Date 2019/9/18 21:02
 * @Version V1.0
 **/
public class ReverseLinkleNode {
    public static void main(String[] args) {
    ListNode node =  new ListNode(0);
    initListNode(node);
     Solution solution = new Solution();

        ArrayList<Integer> list = solution.printListFromTailToHead(node);

        for(Integer i : list){
            System.out.println(i);
        }

    }

    /**
     * @Description //初始化ListNode
     * @Date 2019/9/18 21:25
     * @Param
     * @return
     **/
    public static void initListNode(ListNode node){
        if(node == null||node.val == 10 || false ) {
            return;
        }
        ListNode nextNode = new ListNode(node.val+1);

        node.nextNode = nextNode;

        initListNode(nextNode);
    }

     static class Solution {
        /**
         * @Description //获取Listnode放在arrayList中并反转
         * @Date 2019/9/18 21:25
         * @Param
         * @return
         **/
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(listNode.val);
            while (listNode.nextNode!=null){
                listNode = listNode.nextNode;
                list.add(listNode.val);
            }
            Collections.reverse(list);//反转
            return list;
        }

    }

}

class ListNode{
    int val;
    ListNode nextNode = null;
    ListNode(int val){
        this.val = val;
    }

}
