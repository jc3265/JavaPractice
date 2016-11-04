/**
 * 
 */
package jc3265;

/**
 * @author Zrtho
 *
 */
public class ViveDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ViveDifference driver = new ViveDifference();
		driver.method(1, 3, 5, 9, 0);
		driver.method(4, 3, 2, 1, 0);
		driver.method(1, 1, 1, 1, 0);
	}

	/*
	 * Take any four positive integers: a, b, c, d. Form four more, like this:
	 * |a-b| |b-c| |c-d| |d-a| That is, take the absolute value of the
	 * differences of a with
	 */

	void method(int a, int b, int c, int d, int ways) {
		if ((a == b) && (b == c) && (b == d))
			System.out.println(ways);
		else
			method(Math.abs((a - b)), Math.abs((b - c)), Math.abs((c - d)), Math.abs((d - a)), (ways + 1));
	}
}
