package JianZhiOffer;


/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。不得使用库函数，不需要考虑大数问题
 * */
public class code16_Power {
	public static void main(String args[]) {
		System.out.println(Power(0.5,-2));
		System.out.println(Power(0.5,2));
		System.out.println(Power(0,2));
		System.out.println(Power(0.5,0));
	}
	/*
	 * 题目其实不是很难，只是考虑问题要全面，不能仅仅考虑正常输入，还要考虑边界和异常输入
	 * 1. 正常考虑是：base>0,exponent>1,这种情况下就很容易实现和完成
	 * 2. 当base=0时候要怎么考虑？
	 * 3. 当exponent = 0呢，当exponent < 0 呢？
	 * 4. 注意事项：不能用==比较两个浮点数是否相等，因为有误差。
	 * */
	public static double Power(double base, int exponent) {
		if(equal(base,0)) {
			return 0;
		}
		if(exponent == 0) {
			return 1;
		}
		if(exponent > 0) {
			return mutiply2(base,exponent);
		}else {
		    /*这里处理的很巧妙，将exponent取反，将base取倒数*/	
			return mutiply2(1.0/base,-exponent);
		}
	}
	/*普通的方法来实现累乘*/
	public static double mutiply1(double base,int exponent) {
		double result = 1.0;
		while(exponent != 0) {
			result *= base;
			exponent--;
		}
		return result;
	}
	
	/*迭代的方法来实现累乘*/
	public static double mutiply2(double base, int exponent) {
		if(exponent == 1) {
			return base;
		}
		/*用右移运算符来代替除以2*/
		double result = mutiply2(base,exponent >> 1);
		result *= result;
		/*判断最后一位是否为1，如果是，说明exponent是奇数，最后要乘以base*/
		if((exponent&0x1) == 1) {
			result = result * base;
		}
		return result;
	}
	
	
	public static boolean equal(double a,double b) {
		if(a-b < 0.0000001 && a-b > -0.0000001) {
			return true;
		}
		return false;
	}

}
