import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  */
  
  public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length<3) return -1;//error check
        Arrays.sort( num);
        int sum,distance,closestSum=num[0]+num[1]+num[2],closestDistance=Integer.MAX_VALUE;
        for (int i=0;i<num.length-2;i++){
          int j = i+1, k = num.length-1;
          while(j<k){
            sum = num[i]+num[j]+num[k];
            distance = Math.abs( target - sum );
            if(distance < closestDistance){
              closestDistance = distance;
              closestSum = sum;
            }
            if(sum < target){
              j++;
            }else if(sum > target){
              k--;
            }else{
              return target;
            }
          }
        }
        return closestSum;
    }
    
    public static void main(String[] args){
      ThreeSumClosest s = new ThreeSumClosest();
      System.out.println( s.threeSumClosest( new int[]{-1,2,1,-4}, 1) );
      System.out.println( s.threeSumClosest( new int[]{0,0,0}, 1) );
    }
}