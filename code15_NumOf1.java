package JianZhiOffer;

/*这个函数是用来判断输入的证书转换为二进制的时候有多少个1*/
public class code15_NumOf1 {
	public static void main(String args[]) {
		System.out.print(NumOf1(2));
	}

	public static int NumOf1(int k) {
		int count = 0;
		/* 如果k刚开始不等于0，说明其至少有一个1 */
		while (k != 0) {
			count++;
			/* 进行这个运算之后，k中1的个数就减少了一个 */
			/*
			 * 把一个整数减去1之后再和原来的整数进行位与运算，得到的结果相当于把整数的二进制表示中最右边的1变为0. 很多问题都可以根据这种思路来求解
			 */
			k = (k - 1) & k;
		}
		return count;
	}
}
