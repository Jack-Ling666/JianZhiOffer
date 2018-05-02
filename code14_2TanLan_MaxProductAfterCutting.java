package JianZhiOffer;

/*
 * 通过谈论算法来实现这个过程：当n>=5时，我们尽可能多地剪出长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成长度为2的绳子；
 * 则得到的各段绳子的长度的乘积最大。
 * */
public class code14_2TanLan_MaxProductAfterCutting {
	public static int maxProductAfterCutting(int length) {
		/* 前面部分还是跟动态规划类似 */
		if (length < 2) {
			return 1;
		}
		if (length == 2) {
			return 2;
		}
		if (length == 3) {
			return 3;
		}
		/* 求出这个length长度能剪出多少段长度为3的绳子 */
		int timesOf3 = length / 3;
		/* 当长度为4的时候，能剪出多少段长度为2 的绳子 */
		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}
		int timesOf2 = (length - timesOf3 * 3) / 2;
		/* 通过指数运算求出其乘积 */
		return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
	}

}
