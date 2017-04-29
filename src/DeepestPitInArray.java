// you can also use imports, for example:
// import java.math.*;
//given a zero-indexed array of integers A[N], we can define a "pit" (of this array) a triplet of integers (P,Q,R) such that they follow these rules:
//
//0 ≤ P < Q < R < N
//
//A[P] > A[P+1] > ... > A[Q] (strictly decreasing) and
//
//A[Q] < A[Q+1] < ... < A[R] (strictly increasing).
//
//We can also define the depth of this pit as the number
//
//min{A[P] − A[Q], A[R] − A[Q]}.
//
//You should write a Java method (function) deepest_pit(int[] A) which returns the depth of the deepest pit in array A or -1 if it does not exit.
//
//Costraints: N is an integer within the range [1..1,000,000]; each element of array A is an integer within the range [−100,000,000..100,000,000].given a zero-indexed array of integers A[N], we can define a "pit" (of this array) a triplet of integers (P,Q,R) such that they follow these rules:
//
//0 ≤ P < Q < R < N
//
//A[P] > A[P+1] > ... > A[Q] (strictly decreasing) and
//
//A[Q] < A[Q+1] < ... < A[R] (strictly increasing).
//
//We can also define the depth of this pit as the number
//
//min{A[P] − A[Q], A[R] − A[Q]}.
//
//You should write a Java method (function) deepest_pit(int[] A) which returns the depth of the deepest pit in array A or -1 if it does not exit.
//
//Costraints: N is an integer within the range [1..1,000,000]; each element of array A is an integer within the range [−100,000,000..100,000,000].

class DeepestPitInArray {
    public static int solution(int[] A) {
        if (A.length==0) return 0;
        int MaxDecreasing=0,MaxIncreasing=0,depth=0;
        boolean Positive=true; // whether former one is positive
        int Diff=0;
        for (int i=0;i<A.length-1;i++){
        	Diff=A[i]-A[i+1];
            if (Positive){
                if (Diff<0){ //if it's increasing
                Positive=false;
                MaxIncreasing+=Diff;
                MaxDecreasing=0;
                }
                else { //decreasing
                    MaxDecreasing+=Diff;
                }
            }
            else // if negative
                {
                    if (Diff<0){ //increasing
                        MaxIncreasing+=Diff;
                    }
                    else { //decreasing
                        Positive=true;
                        MaxDecreasing+=Diff;
                    }
                }
            depth=Math.max(depth,Math.min(MaxDecreasing,-MaxIncreasing));
        }
        return depth;
    	
//    	int N = A.length;
//
//    	int depth = -1;
//    	int P, Q, R;
//    	int i = 0, j, k;
//    	while (i < N - 2) {
//    	    P = A[i];
//
//    	    j = i + 1;
//    	    int p = P;
//    	    while (j < N - 1 && A[j] < p) {
//    	        p = A[j++];
//    	    }
//    	    if (j == N - 1) {
//    	        break;
//    	    }
//    	    if (j > i + 1) {
//    	        Q = A[j - 1];
//    	    } else {
//    	        i++;
//    	        continue;
//    	    }
//    	    k = j;
//    	    int q = Q;
//    	    while (k < N && A[k] > q) {
//    	        q = A[k++];
//    	    }
//
//    	    if (k > j) {
//    	        R = A[k - 1];
//    	        depth = Math.max(depth, Math.min(P - Q, R - Q));
//    	        i = k - 1;
//    	    } else {
//    	        i = j - 1;
//    	    }
//    	}
//
//    	return Math.max(depth, -1);
    }
    
    public static void main(String[] args){
        int A[]= {0, 1, 3, -5, 0, 1, 0, -3, 2, 3};
        System.out.println(solution(A));
    }
}

//思路是对的，代码还是有问题，跑对了个别test case，早知道上网去copy一个过来草