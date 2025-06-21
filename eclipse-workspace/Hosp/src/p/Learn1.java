package p;

import java.util.Arrays;
import java.util.List;

public class Learn1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr2 = {1,2,3,4,5,6,456,66,77,88,99};
		
		for (int i = 0 ; i<arr2.length; i++) {
			if (arr2[i]%2 == 0) 
			{
			System.out.println(arr2[i]+" is divided by 2");
			}
			else
			{
			System.out.println(arr2[i]+" is not divided by 2");
			}
			List arr3 = Arrays.asList(arr2);
		}	
	}
}
