/**
 * 
 */
package jc3265;

import java.util.Arrays;

/**
 * @author Zrtho
 *
 */
public class Ways {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ways myWays = new Ways();
		//myWays.driver(100);
		myWays.driver2(20);
		myWays.driver2(200);

	}
	
	void driver(int change){
		int coins[]={1, 5, 10, 25, 50};
		int numberOfCoins = 5;
		int ways[] = new int [change+1];
		//Arrays.fill(ways, 0);
		ways[0]=1;
		for (int i =0; i < numberOfCoins; ++i)
			for(int j = coins[i]; j <= change; ++j){
				ways[j] += ways[j-coins[i]];
				System.out.println("Ways: " + ways[j]+ " Value of J: " + j +" Coins: " + coins[i] );
			}
		System.out.println(ways[change]);
	}

	
	void driver2(int change){
		int coins[]={5, 10, 20,50,100,200,500,1000,2000,5000,10000};
		int numberOfCoins = 11;
		int ways[] = new int [change+1];
		//Arrays.fill(ways, 0);
		ways[0]=1;
		for (int i =0; i < numberOfCoins; ++i)
			for(int j = coins[i]; j <= change; ++j){
				ways[j] += ways[j-coins[i]];
				//System.out.println("Ways: " + ways[j]+ " Value of J: " + j +" Coins: " + coins[i] );
			}
		System.out.println(ways[change]);
	}
}
