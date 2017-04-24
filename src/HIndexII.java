//A scientist has index h if h of his/her N papers have at least h 
//citations each, and the other N - h papers have no more than h citations each

//Follow up for H-Index: What if the citations array is sorted in 
//ascending order? Could you optimize your algorithm?

/*
 * The idea is to search for the first index from the sorted array so that :
 * citations[index] >= length(citations) - index. 
 * And return (length - index) as the result.
 */

/*
 * Standard binary search
 * Just binary search, each time check citations[mid]
 * case 1: citations[mid] == len-mid, then it means there are citations[mid] papers 
 * that have at least citations[mid] citations.
 * case 2: citations[mid] > len-mid, then it means there are citations[mid] papers 
 * that have more than citations[mid] citations, 
 * so we should continue searching in the left half
 * case 3: citations[mid] < len-mid, we should continue searching in the right side
 */
public class HIndexII
{
  public int hIndex(int[] citations){
    int len = citations.length, left = 0, right = len - 1, mid;
    while(left <= right){
      mid = left + (right - left) / 2;
      if(citations[mid] == (len - mid)){
        return len - mid;
      }
      else if(citations[mid] > (len - mid)){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }
    return len - left; 
    // why?, maybe because it's h paper >= h citations, 
    // so take lower bound. (left = right + 1 )
    // e.g. 1 2 4 5, h index is 2, not 3.
  }
}
