package javademo;

public class MaximumNumberFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] abc = { { 0, 4, 7 }, { 0, 3, 7 }, { 1, 9, 6 } };
		int min = abc[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (abc[i][j] < min) {
					min = abc[i][j];
				}

			}
		}
		System.out.println(min);

	}

}
