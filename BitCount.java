/**
 * 
 */
package jc3265;

/**
 * @author Zrtho
 *
 */
public class BitCount {
	/*
	 * Start with an integer, N0, which is greater than 0. Let N1 be the number
	 * of ones in the binary representation of N0. So, if N0=27, N1=4. For all
	 * i>0, let Ni be the number of ones in the binary representation of Ni-1.
	 * This sequence will always converge to one. For any starting number, N0,
	 * let K be the minimum value of i>=0 for which Ni=1. For example, if N0=31,
	 * then N1=5, N2=2, N3=1, so K=3. Given a range of consecutive numbers, and
	 * a value X, how many numbers in the range have a K value equal to X? Input
	 * There will be several test cases in the input. Each test case will
	 * consist of three integers on a single line: LO HI X Where LO and HI (1 <=
	 * LO <= HI <= 1018) are the lower and upper limits of a range of integers,
	 * and X (0 <= X <= 10) is the target value for K. The input will end with a
	 * line with three 0s. Output For each test case, output a single integer,
	 * representing the number of integers in the range from LO to HI
	 * (inclusive) which have a K value equal to X in the input. Print each
	 * integer on its own line with no spaces. Do not print any blank lines
	 * between answers.
	 */

	public static void main(String[] args) {
		BitCount bc = new BitCount();
		bc.driver(31, 31, 3);
		bc.driver(31, 31, 1);
		bc.driver(27, 31, 1);
		bc.driver(27, 31, 2);
		bc.driver(1023, 1025, 1);
		bc.driver(1023, 1025, 2);
	}

	void driver(int lower, int upper, int K) {
		int k = 0;
		int total = 0;
		int numOfOne = 0;
		for (int i = lower; i <= upper; ++i) {
			k = 0;
			numOfOne = i;
			while (numOfOne != 1) {
				numOfOne = Integer.bitCount(numOfOne);// number of 1
				k++;
			}
			if (k != K)
				continue;
			else
				total++;
		}
		System.out.println(total);
	}

}
