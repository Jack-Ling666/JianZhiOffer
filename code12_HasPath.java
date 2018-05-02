package JianZhiOffer;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
*/

public class code12_HasPath {
	public static void main(String args[]) {

	}

	/*
	 * 思路：回溯法，双层for循环，判断每一个点，每次递归调用上下左右四个点， 
	 * 用flag标志是否已经匹配（return），进行判断点的位置是否越界，
	 * 是否已经正确匹配，判断矩阵的路径与模式串的第index个字符是否匹配。
	 */
	

	/*整理一下思路：
	 * 1.两个for循环遍历所有matrix所有的元素，定义一个表示访问过的数组（其实可以用哈希表来代替）（注意传入的一些参数）
	 * 2.判断如果数组的元素与字符串对应的元素不相等或者返回的是已经被访问过的位置时，直接返回false（还有i，j界限的判断）
	 * 3.迭代的停止条件，当k（即所要查找的字符串的下标）为最后一个时， 返回true
	 * 4.标记下标，进行递归判断，下面记得复位为0*/

	
	/*输入的数组matrix[]，行数rows，列数cols，str是要找的字符串，返回输入的数组是否含有这个字符串的路径*/
	public boolean hasPath1(char[] matrix, int rows, int cols, char[] str) {
		int flag[] = new int[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper1(matrix, rows, cols, i, j, str, 0, flag))
					return true;
			}
		}
		return false;
	}

	private boolean helper1(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
		/*对应到字符串的哪个位置上*/
		int index = i * cols + j;
		/*如果数组的元素与字符串对应的元素不相等或者返回的是已经被访问过的位置时，直接返回false*/
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
			return false;

		
		/*迭代的停止条件，当k（即所要查找的字符串的下标）为最后一个时， 返回true*/
		if (k == str.length - 1)
			return true;
		
		/*并且将已经遍历过的元素下标置为1，表示已经遍历过，不能再遍历了*/
		flag[index] = 1;

		if (helper1(matrix, rows, cols, i - 1, j, str, k + 1, flag)
				|| helper1(matrix, rows, cols, i + 1, j, str, k + 1, flag)
				|| helper1(matrix, rows, cols, i, j - 1, str, k + 1, flag)
				|| helper1(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
			return true;
		}
		/*回溯了，把index的flag值重新复位为0*/
		flag[index] = 0;
		return false;
	}
	
	
	/*下面是我的coding*/
	public static boolean hasPath2(char matrix[], int rows, int cols,char str[]) {
		int flag[] = new int[matrix.length];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(help2(matrix,rows,cols,i,j,str,0,flag))
					return true;
			}
		}
		return false;
	}
	
	public static boolean help2(char matrix[],int rows,int cols,int i, int j, char str[],int k,int flag[]) {
		int index = i * rows + j;
		if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1) {
			return false;
		}
		if(k == str.length-1) {
			return true;
		}
		flag[index] = 1;
		if(help2(matrix,rows,cols,i-1,j,str,k+1,flag) || help2(matrix,rows,cols,i+1,j,str,k+1,flag)
				||help2(matrix,rows,cols,i,j-1,str,k+1,flag) || help2(matrix,rows,cols,i,j+1,str,k+1,flag)) {
			return true;
		}
		flag[index] = 0;
		return false;
	}
	
	
	
	
	
	
	
	
	
}