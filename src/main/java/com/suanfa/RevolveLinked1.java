package com.suanfa;

/**
 * @author yangyangl
 * @date 2019-01-22 20:06
 */
public class RevolveLinked1 {

    public static class C08_RevolveLinked1 {
        // 单向链表
        public static class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        // 反转单向链表
        public static Node reverseList(Node head) {
            Node next = null;
            Node pre = null;
            while (head != null) {
                next = head.next;// 备份
                head.next = pre;// 将头节点的下一个节点指向空（pre）
                pre = head;// pre指向原来的头节点
                head = next;// 头节点变为了它的下一节点（向下移动了一位）
            }
            return pre;// 因为head是在为空的时候退出的循环，所以应该返回他的上一节点
        }


        // 打印单向链表
        public static void printList(Node head) {
            System.out.print("Linked List:");
            while (head != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
            System.out.println();
        }



        // 双向链表
        public static class DoubleNode {
            int value;
            DoubleNode last;
            DoubleNode next;

            public DoubleNode(int value) {
                this.value = value;
            }
        }
        // 反转双向链表
        public static DoubleNode reverseList(DoubleNode head) {
            DoubleNode pre = null;
            DoubleNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                head.last = next;
                pre = head;
                head = next;
            }
            return pre;
        }

        // 打印双向链表
        // 分正向和反向打印！！
        public static void printList(DoubleNode head) {
            System.out.print("Double Linked List: ");
            DoubleNode end = null;
            while (head != null) {
                System.out.print(head.value + " ");
                end = head;
                head = head.next;
            }
            System.out.print(" ||  ");
            while (end != null) {
                System.out.print(end.value + " ");
                end = end.last;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Node head1 = new Node(1);
            head1.next = new Node(2);
            head1.next.next = new Node(3);
            printList(head1);
            head1 = reverseList(head1);
            printList(head1);

            System.out.println("==================");

//            DoubleNode head2 = new DoubleNode(1);
//            head2.next = new DoubleNode(2);
//            head2.next.last = head2;
//            head2.next.next = new DoubleNode(3);
//            head2.next.next.last = head2.next;
//            head2.next.next.next = new DoubleNode(4);
//            head2.next.next.next.last = head2.next.next;
//            printList(head2);
//            printList(reverseList(head2));
        }
    }



}
