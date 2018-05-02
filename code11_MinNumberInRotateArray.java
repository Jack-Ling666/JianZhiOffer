package JianZhiOffer;

/*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *   例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0*/

public class code11_MinNumberInRotateArray {
	public static void main(String args[]) {
		int arr[] = {3,4,5,3,3,3};
		System.out.println(MinNumberInRotateArray1(arr));
		System.out.println(MinNumberInRotateArray2(arr));
	}
	
	public static int MinNumberInRotateArray1(int [] array) {
	    if (array == null || array.length == 0)
	        return 0;
	    int left = 0;
	    int right = array.length - 1;
	    int mid = 0;

	    while (array[left] >= array[right]) {
	        if(right - left <= 1) {
	            mid = right;
	            break;
	        }
	        mid = (left + right)/2;
	        if (array[left] == array[mid] && array[mid] == array[right]) {
	            if (array[left+1] != array[right-1]) {
	                mid = array[left+1] < array[right-1] ? left+1:right-1;
	            } else {
	              left++;
	              right--;
	            }
	        } else {
	          if (array[left] <= array[mid]) {
	              left = mid;
	          } else {
	              right = mid;
	          }
	        }
	    }

	    return array[mid];
	}

	public static int MinNumberInRotateArray2(int arr[]) {

		/*这倒编程题看起来不难，但是实际上要考虑的东西却是很多，主要有一下几种情况（把握这几点，情况就清晰了）：
		 * 1. 当0个元素被搬到后面时，即arr[left] < arr[right]时，直接返回arr[mid]
		 * 2. 当arr[right] == arr[left] && arr[right] == arr[mid]，情况又该如何处理（顺序查找咯）
		 * 3. 当数组为空时，直接返回0
		 * 4. 循环结束的条件又是什么：arr[left] < arr[right]*/
		
		/*
		 * 思路：利用二分法，找到中间的数，然后和最左边的值进行比较， 若大于最左边的数，则最左边从mid开始， 若小于最右边值，则最右边从mid开始。
		 * 若左中右三值相等，则顺序查找。
		 */
		int left = 0;
		int right = arr.length - 1;
		/*一旦发现0个元素被搬到后面时，即arr[left] < arr[right]时，直接返回arr[mid]*/
		int mid = left;
		if (arr == null || arr.length == 0) {
			return 0;
		}
		/*程序停止的条件*/
		while (arr[left] >= arr[right]) {
			/*当他们相邻的时候，右边那个元素就是最小值了*/
			if (right - left == 1) {
//				mid = right;
//				break;
				return arr[right];
			}
			mid = (right - left) / 2 + left;
			if (arr[right] == arr[left] && arr[right] == arr[mid]) {
				return MinInOrder(arr, left, right);
			}
			if (arr[left] <= arr[mid]) {
				left = mid;
			} else if (arr[right] >= arr[mid]) {
				right = mid;
			}
		}
		return arr[mid];
	}

	public static int MinInOrder(int arr[], int left, int right) {
		int min = arr[left];
		for (int i = left; i < right; i++) {
			if (arr[left] < min) {
				min = arr[left];
			}
		}
		return min;
	}

}
