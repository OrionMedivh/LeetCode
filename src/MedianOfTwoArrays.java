public class MedianOfTwoArrays {
public static double findMedianSortedArrays(int A[], int B[]) {
	int m = A.length;
	int n = B.length;
 
	if ((m + n) % 2 != 0) // odd
		return findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
	else { // even
		return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
			+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
	}
}
 
public static int findKth(int A[], int B[], int k, 
	int aStart, int aEnd, int bStart, int bEnd) {
 
	int aLen = aEnd - aStart + 1;
	int bLen = bEnd - bStart + 1;
 
	// Handle special cases
	if (aLen == 0)// a is empty
		return B[bStart + k];
	if (bLen == 0)// b is empty
		return A[aStart + k];
	if (k == 0)// if it is the beginning, check which is smaller
		return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
 
	int aMid = aLen * k / (aLen + bLen); // a's middle count, k was distributed evenly;
	int bMid = k - aMid - 1; // b's middle count
 
	// make aMid and bMid to be array index
	aMid = aMid + aStart;
	bMid = bMid + bStart;
 
	if (A[aMid] > B[bMid]) {
		k = k - (bMid - bStart + 1);
		aEnd = aMid;
		bStart = bMid + 1;
	} else {
		k = k - (aMid - aStart + 1);
		bEnd = bMid;
		aStart = aMid + 1;
	}
 
	return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

	public static void main (String[] args){
		int[] A=new int[]{1,2,3,4,5,6,7,8};
		int[] B=new int[]{1,2,3,4,5};
		System.out.println(findMedianSortedArrays(A,B));
	}
}