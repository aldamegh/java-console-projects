
public class a04 {

	public static void main(String[] args) {

		int x = 100;
		int[] nums = new int[ x];
		
		for(int i=1 ; i<nums.length ; ++i) {
			
			
			nums[i]= i+i+1;
			System.out.println(nums[i-1]);
		}
   
		int []arrys= new int [100];
		
        for (int i = 0; i < arrys.length; i++)
        {
            if (i == 0)
                arrys[i] =1;
            else
                arrys[i] = arrys[i - 1] + 2;

			System.out.println(arrys[i]);




        }	
		
	}

}
