import java.util.ArrayList;

public class Combination {
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
//    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//        if (k==0) return result;
//        if (k==1) {
//            for (int i=1;i<=n;i++){
//                ArrayList<Integer> a=new ArrayList<Integer>();
//                a.add(i);
//                result.add(a);
//            }
//            return result;
//        }
//        if (n==k) {
//            ArrayList<Integer> a=new ArrayList<Integer>();
//            for(int i=1;i<=n;i++) a.add(i);
//            result.add(a);
//            return result;
//        }
//        result.addAll(combine(n-1,k));//C(n-1)k;
//        for (ArrayList<Integer> i:combine(n-1,k-1)){//C(n-1)k-1;
//            i.add(n);
//            result.add(i);
//        }
//        return result;
    	
        return combine(n,k,1);   
    }
    
    public static ArrayList<ArrayList<Integer>> combine(int n, int k, int current){
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (k==0) return result;
        if (k==1) {
            for (int i=current;i<=n;i++) 
            {
                ArrayList<Integer> a=new ArrayList<Integer>();
                a.add(i);
                result.add(a);
            }
            return result;
        }
        for (int i=current;i<=n-k+1;i++){
            for (ArrayList<Integer> j:combine(n,k-1,i+1)){
                j.add(0, i);
                result.add(j);
            }
        }
        return result;
    }
    
    public static void main(String args[]){
    	System.out.println(combine(4,2));
    }
}