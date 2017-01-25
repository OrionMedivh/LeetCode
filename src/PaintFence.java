
/*
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 * 
 */

public class PaintFence
{
  public int numWays(int n, int k) {
    if(n==0) return 0;
    int same = 0, diff = k, newSame = 0, newDiff = 0;
    for(int i=1;i<n;i++){
      newSame = diff;
      newDiff = (same+diff)*(k-1);
      same = newSame;
      diff = newDiff;
    }
    return same+diff;
  }
  
  public static void main(String[] args){
    PaintFence s = new PaintFence();
    System.out.println( s.numWays( 0, 1 ) );
    System.out.println( s.numWays( 1, 1 ) );
    System.out.println( s.numWays( 1, 0 ) );
  }
}
