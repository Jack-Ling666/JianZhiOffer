package JianZhiOffer;

/*
 * 动态规划解法：改变策略，正常情况下是从上而下，但是这样的话会有很多长度被重复计算，
 * 所以采用自下而上的解法，将一些值保存到数组中，避免重复计算
 * */
public class code14_1Dynamic_MaxProductAfterCutting {
	public static void main(String args[]) {

	}

	public static int maxProductAfterCutting1(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		/*
		 * 注意数组的长度是length+1，而不是length，因为数组的含义是：
		 * 数组中第i个元素表示把长度为i的绳子剪成若干段之后各段长度乘积的最大值
		 * 而长度不可能为0，所以数组下标从1开始，导致数组长度应该设为length+1
		 * */
		int product[] = new int[length + 1];
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		int max = 0;
		/*从下而上体现在这里*/
		for (int i = 4; i < length + 1; i++) {
			max = 0;
			/*j是小于等于i/2，而不是i,否则还是会有重复计算的情况*/
			for (int j = 1; j <= i / 2; j++) {
				int products = product[j] * product[i - j];
				if (products > max) {
					max = products;
				}
				
				
				product[i] = max;
			}
		}
		max = product[length];
		return max;

	}

}
