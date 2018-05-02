package JianZhiOffer;

public class code10_2_FlogJumpTaiJie {
	public static void main(String args[]) {
		System.out.println(flogJumpTaiJie1(10));
		System.out.println(flogJumpTaiJie2(10));
//		System.out.println(flogJumpTaiJie3(10));
	}

	public static int flogJumpTaiJie1(long n) {
		int result = 0;
//		int sum = 0;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		} else {
			 result = flogJumpTaiJie1(n - 1) + flogJumpTaiJie1(n - 2) ;
//			 sum += result; 
		}
		return result;
	}

	public static int flogJumpTaiJie2(long n) {
		int i = 0;
		int j = 1;
		int result = 0;
//		int sum = 0;
		if (n <= 0) {
			return i;
		}
		if (n == 1) {
			return j;
		} else {
			for (int k = 2; k <= n; k++) {
				result = i + j ;
				i = j;
				j = result;
//				sum += result;
			}
			return result;
		}
	}

//	public static int flogJumpTaiJie3(int n) {
//		int number = 1;
//		int sum = 1;
//		if (n <= 0)
//			return 0;
//		if (n == 1) {
//			return 1;
//		}
//
//		while (n-- >= 2) {
//			sum += number;
//			number = sum - number;
//		}
//		return sum;
//	}

}
