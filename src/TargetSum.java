
public class TargetSum
{
  /*
  The recursive solution is very slow, because its runtime is exponential

  The original problem statement is equivalent to:
  Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

  Let P be the positive subset and N be the negative subset
  For example:
  Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
  Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

  Then let's see how this can be converted to a subset sum problem:

                    sum(P) - sum(N) = target
  sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                         2 * sum(P) = target + sum(nums)
  So the original problem has been converted to a subset sum problem as follows:
  Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

  Note that the above formula has proved that target + sum(nums) must be even
  We can use that fact to quickly identify inputs that do not have a solution
  For detailed explanation on how to solve subset sum problem, you may refer to Partition Equal Subset Sum

  */

  public int findTargetSumWays( int[] nums, int s )
  {
    int sum = 0;
    for ( int n : nums )
      sum += n;
    if(sum < s) return 0;
    if(( s + sum ) % 2 > 0) return 0;
    return subsetSum( nums, ( s + sum ) >>> 1 ); // >>> unsigned divided by 2;
  }

  public int subsetSum( int[] nums, int s )
  {
    int[] dp = new int[s + 1];
    dp[0] = 1;
    for ( int n : nums )
      for ( int i = s; i >= n; i-- )
        dp[i] += dp[i - n];
    return dp[s];
  }
}
