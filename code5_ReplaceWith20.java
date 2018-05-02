package JianZhiOffer;

/*将一个字符串中的空格替换成“%20”。 
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class code5_ReplaceWith20 {
	public static void main(String args[]) {
		/* 注意一些常用的字符串操作 */
		StringBuilder st = new StringBuilder().append("we are the world");

		System.out.println(ReplaceWith20(st));
	}

	public static String ReplaceWith20(StringBuilder str) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (String.valueOf(str.charAt(i)).equals(" ")) {
				sb.append("%20");
			} else {
				/* 取得第i个元素的值 */
				sb.append(str.charAt(i));
			}
		}
		return String.valueOf(sb);
	}

}
