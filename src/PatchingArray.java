
//Given a sorted positive integer array nums and an integer n, add/patch elements 
//to the array such that any number in range [1, n] inclusive can be formed by the 
//sum of some elements in the array. Return the minimum number of patches required.
//
//Example 1:
//nums = [1, 3], n = 6
//Return 1.
//
//Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
//Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
//Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
//So we only need 1 patch.
//
//Example 2:
//nums = [1, 5, 10], n = 20
//Return 2.
//The two patches can be [2, 4].
//
//Example 3:
//nums = [1, 2, 2], n = 5
//Return 0.

public class PatchingArray
{
//    public int minPatches(int[] nums, int n) {
//        boolean[] store = new boolean[n+1];
//        boolean[] store2 = new boolean[n+1];
//        store[0] = true;
//        store2[0] = true;
//        int f = n; // the count that how many are not set
//        for(int i=0;i<nums.length;i++){
//          for(int j = 0;j<=n;j++){
//            if(store[j] == true && j+nums[i] <=n ) {
//              store2[j+nums[i]]=true;
//              f--;
//            }
//          }
//          store = Arrays.copyOf( store2, n+1 );
//        }
//        
//        int count = 0;
//        while(f>0){
//          int i =n;
//          int upper;
//          int lower;
//          while( store[i] == true){
//            i--;
//          }
//          upper = i;
//          while( store[i] == false){
//            i--;
//          }
//          lower = i;
//          for(int j =0;j<=n;j++){
//            if(store[j] == true && j+upper-lower <=n){
//              store2[j+upper-lower]=true;
//              f--;
//            }
//          }
//          store = Arrays.copyOf(store2, n+1);
//          count++;
//        }
//        
//        return count;
//    } // range out of bound , bad implementation.

//public int minPatches( int[] nums, int n ){
//    int miss = 1, added = 0, i = 0;
//    while (miss <= n) {
//        if (i < nums.length && nums[i] <= miss) {
//            miss += nums[i++];
//        } else {
//            miss += miss;
//            added++;
//        }
//    }
//    return added;
//}
  
  public int minPatches( int[] nums, int n ){
    long miss = 1;
    int i = 0, count = 0;
    while(miss <= n){
      if(i < nums.length && nums[i] <= miss){
        miss+=nums[i];
        i++;
      }else{
        miss <<= 1;
        count++;
      }
    }
    return count;
  }
  
//  public int minPatches( int[] nums, int n )
//  {
//    int count = 0, i = 0;
//    for (long miss=1; miss <= n; count++)
//        miss += (i < nums.length && nums[i] <= miss) ? nums[i++] : miss;
//    return count - i;
//  } //shortest

  public static void main( String[] args )
  {
    PatchingArray s = new PatchingArray();
    System.out.println( s.minPatches( new int[]
    { 1, 3, 9 }, 20 ) );
  }
}