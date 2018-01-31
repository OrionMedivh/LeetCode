/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
Note:
All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

 */

public class StringCompression {
	public int compress(char[] chars) {
		int readIndex = 0, writeIndex = 0, anchorIndex = 0; 
		// index of read, write, and the location of first character of the last bunch of same characters
		for (readIndex = 0; readIndex < chars.length; readIndex++) {
			if (readIndex != chars.length - 1 && chars[readIndex] == chars[readIndex + 1]) {
			} else {
				chars[writeIndex++] = chars[anchorIndex];
				if (readIndex > anchorIndex) { // more than 1 character
					for (char c1 : Integer.toString(readIndex - anchorIndex + 1).toCharArray()) {
						chars[writeIndex++] = c1;
					}
				}
				anchorIndex = readIndex + 1;
			}
		}
		return writeIndex;
	}
	
	public int compress2(char[] chars) {
		int readIndex = 0, writeIndex = 0;
		char c = chars[0];
		int count = 0; // to offset start from 1st character
		while (readIndex < chars.length + 1) {
			char curr;
			if (readIndex < chars.length) {
				curr = chars[readIndex];
			} else {
				curr = ' ';
			}
			if (c == curr) {
				count++;
			} else {
				chars[writeIndex++] = c;
				if (count > 1) {
					for (char c1 : Integer.toString(count).toCharArray()) {
						chars[writeIndex++] = c1;
					}
				}
				c = curr;
				count = 1;
			}
			readIndex++;
		}
		return writeIndex;
	}
}
