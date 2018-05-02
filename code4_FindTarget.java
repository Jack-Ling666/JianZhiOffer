package JianZhiOffer;

/*在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/

public class code4_FindTarget {
	public static void main(String args[]) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int target = 9;
		System.out.print(FindTarget(arr, target));
	}

	public static boolean FindTarget(int arr[][], int target) {

		if (arr == null) {
			return false;
		}
		int raw = 0;
		int colum = arr[0].length - 1;
		while ((raw < arr.length) && (colum >= 0)) {
			if (target > arr[raw][colum]) {
				raw++;
			} else if (target < arr[raw][colum]) {
				colum--;
			} else {
				return true;
			}
		}
		return false;
	}

}
