import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] amounts = new int[amount + 1];
		Arrays.fill(amounts, -1);
		amounts[0] = 0;
		for (int i = 0; i < amount; i++) { // from 0 to amount - 1;
			for (int coin : coins) {
				if (coin <= amount - i) {
					if (amounts[i] == -1) { //when current number impossible
						continue;
					}
					if (amounts[i + coin] == -1) { //when target number not initialized
						amounts[i + coin] = amounts[i] + 1;
					} else {
						amounts[i + coin] = Math.min(amounts[i + coin], amounts[i] + 1);
					}
				}
			}
		}
		return amounts[amount];
	}
}
