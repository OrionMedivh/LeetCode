import java.util.Arrays;
import java.util.List;

/*
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
 */

public class CountOfSmallerNumbersAfterSelf
{
  public List<Integer> countSmaller( int[] nums )
  {
    List<Integer> result = Arrays.asList( new Integer[nums.length] );
    TreeNode2 head = new TreeNode2(nums[0], 0 );
    for ( int j = 1; j< nums.length; j++ )
    {
      int i =nums[j];
      TreeNode2 cur = head;
      TreeNode2 pre = cur;
      while ( cur != null )
      {
        if ( i > cur.value )
        {
          pre = cur;
          cur = cur.right;
        }
        else
        {
          cur.smaller++;
          pre = cur;
          cur = cur.left;
        }
      }
      if(i >= pre.value){
        pre.right = new TreeNode2(i, j);
      }else{
        pre.left = new TreeNode2(i, j);
      }
    }
    
    traverse(result, head);
    return result;
  }
  
  public void traverse(List<Integer> result, TreeNode2 node){
    if(node == null){
      return;
    }
    result.set( node.index, node.smaller);
    traverse(result, node.left);
    traverse(result, node.right);
  }
  
  public static void main(String[] args){
    CountOfSmallerNumbersAfterSelf s = new CountOfSmallerNumbersAfterSelf();
    System.out.println( s.countSmaller( new int[]{5,2,6,1} ) );
  }
  
}

class TreeNode2
{
  TreeNode2 left;
  TreeNode2 right;
  int value;
  int smaller;
  int index;

  public TreeNode2( int value, int index )
  {
    this.value = value;
    this.index = index;
  }
}
