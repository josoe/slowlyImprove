package com.leetcode;

import java.util.List;

/**
 * Created by jiazhiwen on 2019/4/3.
 */
public class SortList {
     class ListNode {
            int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    /**
     * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
     *
     * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
     * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
     * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
     * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
     * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
     * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
     * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
     *
     * 主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     */
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    public ListNode mergeSort(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode midNode = listNode;
        ListNode endNOde = listNode;
        while (endNOde.next != null && endNOde.next.next != null) {
            midNode = midNode.next;
            endNOde = endNOde.next.next;
        }
        ListNode nextNode = midNode.next;
        midNode.next = null;
        ListNode firstNode = mergeSort(listNode);
        ListNode secondNode = mergeSort(nextNode);
        return merge(firstNode, secondNode);
    }

    public ListNode merge(ListNode firstNode, ListNode secondNode) {
        ListNode rootNode = new ListNode(0);
        ListNode listNode = new ListNode(0);
        rootNode.next = listNode;
        while (true) {
            if (firstNode == null) {
                while (secondNode != null) {
                    listNode.next = new ListNode(secondNode.val);
                    listNode = listNode.next;
                    secondNode = secondNode.next;
                }
                break;
            }
            if (secondNode == null) {
                while (firstNode != null) {
                    listNode.next = new ListNode(firstNode.val);
                    listNode = listNode.next;
                    firstNode = firstNode.next;
                }
                break;
            }
            if (firstNode.val > secondNode.val) {
                listNode.next = secondNode;
                listNode = listNode.next;
                secondNode = secondNode.next;
            } else {
                listNode.next = firstNode;
                listNode = listNode.next;
                firstNode = firstNode.next;
            }
        }
        return rootNode.next.next;
    }



}
