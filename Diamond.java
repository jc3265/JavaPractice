package jc3265;

import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		Diamond driver = new Diamond();
		driver.drawDiamond();
	}

	void drawDiamond() {// a = ASCII 97
		char bigArray[][];
		Scanner scanny = new Scanner(System.in);
		int letter, rowUp, rowLow, colLeft, colRight;
		int caseNum = 1;
		int ttcx = 0; // times to copy on x
		int ttcy = 0; // times to copy on y
		while (true) {
			letter = scanny.nextInt();
			if (letter == 0)
				break;
			rowUp = scanny.nextInt();
			colLeft = scanny.nextInt();
			rowLow = scanny.nextInt();
			colRight = scanny.nextInt();
			scanny.nextLine();
			double sizeX = 0.0;
			letter = letter % 26;
			char aLet = (char) (letter + 96);
			bigArray = new char[rowLow + 1][colRight + 1];// inclusive
			/////////////////////////////////
			// Initialize the Array to '.' //
			/////////////////////////////////
			for (int row = 0; row <= rowLow; row++) {
				for (int col = 0; col <= colRight; col++) {
					bigArray[row][col] = '.';
				}
			}
			sizeX = ((letter * 2) - 1);
			ttcy = (int) Math.round(colRight / sizeX);
			ttcx = (int) Math.round(rowLow / sizeX);
			int position = letter - 1;
			bigArray[0][position] = aLet;//take care of the first letter
			position--;
			////////////////
			// Upper part //
			////////////////
			for (int row = 1; (row < letter) && position >= 0; row++) {
				int temp = position;
				for (int col = position; col < (letter + row); col++) {
					temp++;
					bigArray[row][col] = aLet;
					if (temp < letter)
						aLet--;
					else
						aLet++;
				}
				aLet = (char) (letter + 96);
				position--;
			}
			////////////////
			// Lower part //
			////////////////
			position = 1;
			int t2 = ((letter - 1) * 2) - 1;
			for (int row = letter; (row < (2 * letter) - 1) && position < letter; row++) {
				int temp = position;
				for (int col = position; col <= t2; col++) {
					temp++;
					bigArray[row][col] = aLet;
					if (temp < letter)
						aLet--;
					else
						aLet++;
				}
				aLet = (char) (letter + 96);
				position++;
				t2--;
			}
			////////////////////////////////////////////
			// Done with first diamond, now copy on X //
			////////////////////////////////////////////
			while (ttcx >= 0) {
				for (int row = 0; row < ((letter - 1) * 2); row++) {
					for (int col = 0; col <= ((letter - 1) * 2); col++) {
						if ((row + sizeX) > rowLow)
							break;
						bigArray[(int) (row + sizeX)][col] = bigArray[row][col];
					}
				}
				ttcx--;
			}
			//////////////////////////////////////
			// Done Copying on x, now copy on Y //
			//////////////////////////////////////
			while (ttcy >= 0) {
				for (int row = 0; row <= rowLow; row++) {
					for (int col = 0; col <= colRight; col++) {
						if ((col + sizeX) > colRight)
							break;
						bigArray[row][(int) (col + sizeX)] = bigArray[row][col];
					}
				}
				ttcy--;
			}
			//////////////////////////////////////
			// Finally, Print the desired parts //
			//////////////////////////////////////
			System.out.println("Case " + caseNum + ":");
			caseNum++;
			for (int row = rowUp; row <= rowLow; row++) {
				for (int col = colLeft; col <= colRight; col++) {
					System.out.print(bigArray[row][col]);
				}
				System.out.println();
			}
			/////////////////////////
			// Print full Diamonds //
			/////////////////////////
			/*
			for (int row = 0; row <= rowLow; row++) {
				for (int col = 0; col <= colRight; col++) {
					System.out.print(bigArray[row][col]);
				}
				System.out.println();
			}
			*/
		}
		scanny.close();
	}
}