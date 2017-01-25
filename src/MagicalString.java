/*
A magical string S consists of only '1' and '2' and obeys the following rules:

The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122……"

If we group the consecutive '1's and '2's in S, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2 2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.

Example 1:
Input: 6
Output: 3
Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */
public class MagicalString
{
  public int magicalString(int n) {
    if(n <=0 ) return 0;
    int[] result = new int[n];
    int index1 = 0,index2=0; // two index, index1 is the generating one. index2 is the result one.
    int count = 1; // count how many '1's we have
    int[] num = new int[]{1,2}; // 0 -> 1; 1 -> 2;
    int rotate = 0; // flip within num[]
    
    do{
      int cur = num[rotate];
      if(result[index1] == 0){
        result[index1] = cur;
      }
      rotate = (rotate+1)%2;
      int range = Math.min(index2 + result[index1], n-1);
      if(cur == 1){
        count+= range-index2;
      }
      for(int i = index2+1; i <= range;i++){
        result[i]=cur;
      }
      index1++;
      index2+=range;
    }while(index2 <= n-1);
    return count;
  }
  
  public static void main(String[] args){
    MagicalString s = new MagicalString();
    System.out.println( s.magicalString( -1 ) );
    System.out.println( s.magicalString( 0 ) );
    System.out.println( s.magicalString( 2 ) );
    System.out.println( s.magicalString( 6 ) );
    System.out.println( s.magicalString( 8 ) );
    System.out.println( s.magicalString( 10 ) );
  }
}
