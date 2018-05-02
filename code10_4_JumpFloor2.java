package JianZhiOffer;

/*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：2^(n-1)*/
public class code10_4_JumpFloor2 {
	public static int JumpFloor2(int n) {
		return (int) Math.pow(2, n - 1);
	}

}
