public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A.length==0) return 0;
        int count=0;//count how many instances removed;
        // int i=0;
        // while(i+count<A.length){
        //     if (A[i+count]==elem){
        //         count++;
        //     }else{
        //         A[i]=A[i+count];
        //         i++;
        //     }
        // }
        for (int i=0;i<A.length;i++){
            if (A[i]==elem){
                count++;
            }else{
                A[i-count]=A[i];
            }
        }
        return A.length-count;
    }
}