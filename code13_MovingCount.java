package JianZhiOffer;

public class code13_MovingCount {
	public static void main(String args[]) {

	}

	public int movingCount1(int threshold, int rows, int cols) {
		int flag[][] = new int[rows][cols]; // 记录是否已经走过
		return helper1(0, 0, rows, cols, flag, threshold);
	}

	private int helper1(int i, int j, int rows, int cols, int[][] flag, int threshold) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum1(i) + numSum1(j) > threshold || flag[i][j] == 1)
			return 0;
		flag[i][j] = 1;
		return helper1(i - 1, j, rows, cols, flag, threshold) + helper1(i + 1, j, rows, cols, flag, threshold)
				+ helper1(i, j - 1, rows, cols, flag, threshold) + helper1(i, j + 1, rows, cols, flag, threshold) + 1;
	}

	private int numSum1(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}

	/* 老实说，这个题目比上一个题目容易一些，不过思想都是一样的，都是利用回溯算法 */
	public static int movingCount2(int max, int rows, int cols) {
		/* 用于记录是否走过 */
		int flag[][] = new int[rows][cols];
		return help2(0, 0, rows, cols, flag, max);
	}

	public static int help2(int i, int j, int rows, int cols, int flag[][], int max) {
		/* 这里的判断和上一个面试题的判断是一样的 */
		if (i < 0 || i >= rows || j < 0 || j > cols || numsum(i) + numsum(j) > max || flag[i][j] == 1) {
			return 0;
		}
		/* 将（0，0）坐标置为1，已经访问过 */
		flag[i][j] = 1;
		/* 最后记得加上1（0，0） */
		return help2(i - 1, j, rows, cols, flag, max) + help2(i + 1, j, rows, cols, flag, max)
				+ help2(i, j - 1, rows, cols, flag, max) + help2(i, j + 1, rows, cols, flag, max) + 1;

	}

	/* 获取坐标各位数之和 */
	public static int numsum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}

}
