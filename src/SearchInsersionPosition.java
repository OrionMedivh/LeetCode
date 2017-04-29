public class SearchInsersionPosition {
    public int searchInsert(int[] A, int target) {
        if (A.length==0) return 0;
        return searchInsert(A, 0, A.length-1, target);
    }
    
    // public int searchInsert(int[] A, int begin, int end, int target){
    //     if (begin==end) {
    //     if (target>A[begin]) return begin+1;
    //     else return begin;
    //     }
    //     int middle=(begin+end)/2;
    //     if (target>A[middle]) return searchInsert(A, middle+1, end, target);
    //     if (target<A[middle]) return searchInsert(A, begin, middle, target);
    //     return middle;
    // }//recursive;
    
    public int searchInsert(int[] A, int begin, int end, int target){
    while (begin!=end){ 
    int middle=(begin+end)/2;
    if (target==A[middle]) return middle;
    if (target>A[middle]) begin=middle+1;
    if (target<A[middle]) end=middle;
    }
    if (target>A[begin]) return begin+1;
    else return begin;
    }//iterative;
}


//public class SearchInsersionPosition {
//    public int searchInsert(int[] nums, int target) {
//        int length = nums.length;
//        if (length == 0) return 0;
//        return searchInsert(nums, target, 0, length); // search position will be from 0 to max+1;
//    }
//    
//    public int searchInsert(int[] nums, int target, int min, int max){
//        if (min == max ) return min;
//        if (nums[(min+max)/2]<target) return searchInsert(nums,target, (min+max)/2+1, max);
//        return searchInsert(nums, target, min, (min+max)/2);
//    }
//} another recursive