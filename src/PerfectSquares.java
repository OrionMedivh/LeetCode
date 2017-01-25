import java.util.Arrays;

//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public class PerfectSquares
{
  public int numSquares( int n )
  {
    int[] result = new int[n + 1];
    Arrays.fill(result, n);
    result[0] = 0;
    for(int i = 0 ; i <= n ; i++){
      {
        for(int j=0; i+j*j<=n;j++){
          result[i+j*j] = Math.min( result[i+j*j], result[i]+1 );
        }
      }
    }
    return result[n];
  }
  
  public static void main(String[] args){
    PerfectSquares s = new PerfectSquares();
    System.out.println( s.numSquares( 8 ) );
  }
}
