package JianZhiOffer;

/*我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/

public class code10_3_RecoveredRectangle {
	/* 思路：斐波那契数列思想 */
	public static void main(String args[]) {
		for (int i = 3; i < 1000; i++) {
			if (RecoverRectangle1(i) != RecoverRectangle2(i)) {
				System.out.println("false");
				break;
			}
		}
		System.out.println("true");
	}

	public static int RecoverRectangle1(int n) {
		int sum = 0;
		int i = 1;
		int j = 2;
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		} else {
			for (int k = 2; k < n; k++) {
				sum = i + j;
				i = j;
				j = sum;
			}
			return sum;
		}
	}

	public static int RecoverRectangle2(int n) {
		int number = 1;
		int sum = 1;
		if (n <= 0)
			return 0;
		if (n == 1) {
			return 1;
		}

		while (n-- >= 2) {
			sum += number;
			number = sum - number;
		}
		return sum;
	}
}
