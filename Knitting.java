/**
 * 
 */
package jc3265;

import java.util.Scanner;

/**
 * @author Zrtho
 *
 */
public class Knitting {

	/**
	 * @param args
	 */
	/*
	 * Marcia loves to knit. As she knits, she wonders how many stitches the
	 * project she is working on will take to complete. On every project, she
	 * starts with a row of a given number of stitches, and then adds more rows.
	 * Sometimes the next row will have the same number of stitches as the
	 * previous row and other times the next row will have more or less stitches
	 * than the previous row. For example, a pattern for a triangular shawl may
	 * begin with just 3 stitches and add 2 stitches on each row. So, the first
	 * row will have 3 stitches, the second row will have 5 stitches, the third
	 * will have 7 stitches, and so on. If the project has a total of 3 rows,
	 * then it has a total of 15 stitches. A more complex scarf project may have
	 * a 4 row repeating pattern that increases 6 stitches on the first row of
	 * the pattern, decreases 2 stitches on each of the next two rows, and has
	 * no change on the final row of the pattern. So, a scarf that has 50
	 * stitches on the first row will have 56 on the second row, 54 on the third
	 * row, 52 on the fourth row, and 52 on the fifth row. On the sixth row, the
	 * pattern repeats, so there will be an increase of 6 stitches for a total
	 * of 58 stitches on that row. If the project stops there at 6 rows, then it
	 * will have a total of 322 stitches. You will write a program to help
	 * Marcia figure out how many stitches a project will take to complete
	 * Sample in: 3 3 1
	 *			  2
	 *		      50 6 4
	 *		      6 -2 -2 0
     *            0 0 0
     * Sample Out: 15
     *             322
	 * 
	 */
	public static void main(String[] args) {
		Knitting kn = new Knitting();
		kn.driver();
	}

	void driver() {
		Scanner scanny = new Scanner(System.in);
		int numberOfStitchesInFirstRow = 0, rowsInProject, numberOfRowsInRepeatingPattern;
		while (true) {
			numberOfStitchesInFirstRow = scanny.nextInt();
			rowsInProject = scanny.nextInt();
			numberOfRowsInRepeatingPattern = scanny.nextInt();
			if (numberOfStitchesInFirstRow == 0 && rowsInProject == 0 && numberOfRowsInRepeatingPattern == 0)
				break;
			int totalStitches = numberOfStitchesInFirstRow;
			int pattern[] = new int[numberOfRowsInRepeatingPattern];
			for (int i = 0; i < numberOfRowsInRepeatingPattern; ++i) {
				pattern[i] = scanny.nextInt();
			}
			int rowTotal = numberOfStitchesInFirstRow;
			int row = 0;
			for (int i = 1; i < rowsInProject; i++) {
				if (row == pattern.length)
					row = 0;
				rowTotal += pattern[row];
				totalStitches += rowTotal;
				++row;
			}
			System.out.println(totalStitches);
		}
		scanny.close();
	}
}
