package javademo;

public class MaxNumberFromMinRowInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] abc = { { 1, 0, 5 }, { 2, 9, 3 }, { 2, 6, 9 } };
		int min = abc[0][0];
		int mincolumn = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (abc[i][j] < min) {
					min = abc[i][j];
					mincolumn = j;

				}

			}

		}
		int max = abc[0][mincolumn];
		for (int k = 0; k < 3; k++) {
			if (abc[k][mincolumn] > max)
				max = abc[k][mincolumn];
			/*
			 * int max = abc[0][mincoloumn]; // Start by assuming the max is at the top row of that column 
			 * int k = 0; 
			 * while (k < 3) 
			 * { 
			 * if (abc[k][mincoloumn] > max) 
			 * { 
			 * max = abc[k][mincoloumn]; // Update max if current value is greater } 
			 * k++;
			 */
		}
		System.out.println(max);

	}

}
