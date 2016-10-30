package jc3265;

import java.util.Scanner;

public class RotatedSquares {

	public static void main(String[] args) {
		RotatedSquares driver = new RotatedSquares();
		driver.squares();
	}
	
	void squares() {
		int N, n;
		String beingRead = "";
		Scanner scanny = new Scanner(System.in);
		while (true) {
			N = scanny.nextInt(); // Size N x N
			n = scanny.nextInt(); // Size n x n
			if (N == 0 && n == 0)
				break;
			beingRead = scanny.nextLine();
			char[][] data = new char[N][N];
			char[][] toCompare = new char[n][n];
			///////////////////////////////////////////
			// Load the Characters of the big square //
			///////////////////////////////////////////
			for (int i = 0; i < N; i++) {
				beingRead = scanny.nextLine();
				for (int j = 0; j < N; j++)
					data[i][j] = beingRead.charAt(j);
			}
			///////////////////////////////////////////
			// Load the Characters of the small square //
			///////////////////////////////////////////
			for (int i = 0; i < n; i++) {
				beingRead = scanny.nextLine();
				for (int j = 0; j < n; j++)
					toCompare[i][j] = beingRead.charAt(j);
			}
			boolean aFlag = false;
			int count = 0;
			for (int rotations = 0; rotations < 4; rotations++) {//Rotate it by 90 degrees
				count = 0;
				for (int i = 0; i < (N - n) + 1; i++)
					for (int j = 0; j < (N - n) + 1; j++) {
						aFlag = true;

						for (int x = 0; x < n; x++) {
							for (int y = 0; y < n; y++) {
								if (toCompare[x][y] != data[i + x][j + y])
									aFlag = false;
							}
						}
						if (aFlag)
							count++;
					}
				toCompare = rotate(toCompare);
				System.out.print(count + " ");
			}
			System.out.println();
		}
		scanny.close();
	}

	char[][] rotate(char[][] toCompare) {
		int len = toCompare.length;
		char[][] theNewRotated = new char[len][len];
		for (int row = 0; row < len; row++)
			for (int column = 0; column < len; column++)
				theNewRotated[column][((len) - 1 - row)] = toCompare[row][column];
		return theNewRotated;
	}
}