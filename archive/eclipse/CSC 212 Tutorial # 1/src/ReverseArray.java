public class ReverseArray{
public static void ReverseArray(int[] arr , int l , int h) {
	
	if (l>=h) return;


	int tmp = arr[l] ;
	
	arr[l] = arr[h];
	
	arr[h] = tmp;
	
	ReverseArray(arr, l+1 , h-1);
	
	}
}
