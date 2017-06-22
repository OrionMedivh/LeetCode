
/*
Write a function that takes an unsigned integer and returns the 
number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 
00000000000000000000000000001011, so the function should return 3.
 */

public class NumberOf1Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		// return Integer.bitCount(n); //cheat
		int count = 0;
		while (n != 0) {
			// need to use != instead of >0 is because of overflow
			count += n & 1;
			n = n >>> 1; // >>> unsigned shift
		}
		return count;
	}
}
