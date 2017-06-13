/*
 * Write a function that takes a string as input and returns the string reversed.
 */

public class ReverseString {
	public String reverseString(String s) {
		return new StringBuffer(s).reverse().toString();
	}
}
