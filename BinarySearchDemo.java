import java.util.Arrays;

/**
 * 
 * @author listar
 * Binary Search without using recursion (iteration instead).
 */
public class BinarySearchDemo {
	
	private static int begin;
	private static int end;
	private static int mid;
	
	public static int doSearch(int [] arr, int target) {
		
		Arrays.sort(arr);
		begin = 0;
		end = arr.length - 1;
		
		while (begin <= end) {
			mid = (end + begin)/2;
			if (arr[mid] == target) {
				return mid;
			}
			else if (arr[mid] > target) {
				end = mid -1;
			}
			else {
				begin = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int [] arr = {1,3,5,6,8,11,15};
		System.out.println(doSearch(arr, 1));
	}

}
