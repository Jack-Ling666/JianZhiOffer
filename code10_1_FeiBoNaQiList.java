package JianZhiOffer;

public class code10_1_FeiBoNaQiList {
	public static void main(String args[]) {

	}

	public static long FeiBoNaQiList1(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return FeiBoNaQiList1(n - 1) + FeiBoNaQiList1(n - 2);
		}
	}

	/* 推荐使用下面这种方法 */
	public static long FeiBoNaQiList2(int n) {
		long i = 0;
		long j = 1;
		long result = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			for (int k = 2; k <= n; k++) {
				result = i + j;
				i = j;
				j = result;
			}
			return result;
		}
	}
}
