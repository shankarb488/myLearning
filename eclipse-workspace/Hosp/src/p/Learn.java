package p;

public class Learn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[2];
		arr[0] = 2;
		arr[1]= 3;
		System.out.println(arr[0]);
		int[] arr1 = {1,2,3,4,5};
		System.out.println(arr1.length);
		for(int i=0; i<arr1.length ; i++) {
			System.out.println(arr1[i]);
		}
		for(int i1=arr1.length-1; i1>=0 ; i1--) {
			//i1=4;4>=0;3 === 5
			//i1=3;3>=0;2 === 4
			//i1=2;2>=0;1 === 3
			//i1=1;1>=0;0 === 2
			//i1=0;0>=0;-1 === 1
			System.out.println(arr1[i1]);
		}

	}

}
