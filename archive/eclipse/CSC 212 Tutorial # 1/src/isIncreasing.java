
public class isIncreasing {
	
	public static boolean isIncreasing (int[] arr , int n) {
		
		if (n==1) 
			return true;
		
		return arr[n-1] >= arr[n-2] &&  isIncreasing (arr, n-1);
	}

}
