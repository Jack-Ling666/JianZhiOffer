package JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/*输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：借助栈实现，或使用递归的方法。*/
public class code6_PrintListReversingly {

	/* 这个链表结构很重要，要很熟悉 */
	public static class ListNode {
		public int value;
		public ListNode next;

		public ListNode(int data) {
			this.value = data;
		}
	}

	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<>();
		/* 这一部分也很重要 */
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		list = PrintListReversingly(node);
		/*ArrayList 的遍历也很重要，要熟悉，注意，是从0开始的*/
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		/*下面这种方法也是可行的*/
		for(Integer lists : list) {
			System.out.println(lists);
		}
	}

	public static ArrayList<Integer> PrintListReversingly(ListNode node) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (node == null) {
			return list;
		}

		while (node != null) {
			st.push(node.value);
			node = node.next;
		}

		while (!st.isEmpty()) {
			list.add(st.pop());
		}
		return list;

	}

}
