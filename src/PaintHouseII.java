
public class PaintHouseII
{
  public int minCostII(int[][] costs) {
    if(costs == null || costs.length == 0|| costs[0] == null || costs[0].length == 0 ) {
      return 0;
    }
    int n = costs.length;
    int m = costs[0].length;
    int min1 = -1;//store the index of color that has 1st min cost of house i
    int min2 = -1;//store the index of color that has 2nd min cost of house i
    for (int i =0; i < n; i++) {
      int lastMin1 = min1;
      int lastMin2= min2;
      min1 = -1;
      min2 = -1;
      for(int j = 0; j < m ; j++){
        if(j!=lastMin1){
          costs[i][j] += (lastMin1 == -1 ) ? 0: costs[i-1][lastMin1];//+=,not= !need original value of costs[i][j]
        }else{
          costs[i][j] += (lastMin2 == -1 ) ? 0: costs[i-1][lastMin2];//if it's first value,costs[i][j]+0=costs[i][j]
        }
        if(min1 == -1 || costs[i][j] < costs[i][min1]){ //if the cost of color j is less than color min1
         min2 = min1; // assign min2 to min1 since it might be the index of second lest value.
         min1 = j; // assign min1 to the index with lesser cost.
        }else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
          min2 = j;// this only determine it might be the 2nd least value index when min1 is the least value index
        }
      }
    }
    return costs[n-1][min1];
  }
}
