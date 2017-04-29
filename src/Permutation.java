import java.util.ArrayList;
import java.util.List;


public class Permutation {
//    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//    	return permute1(num, num.length-1);
//    }
//    
//    public static ArrayList<ArrayList<Integer>> permute1(int[] num, int index)
//    {
//		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
//    	if (index==0){// 1 left in the array.
//    		ArrayList<Integer> subArray= new ArrayList<Integer>();
//    		subArray.add(num[0]);
//    		result.add(subArray);
//    		return result;
//    	}
//    	ArrayList<ArrayList<Integer>> subPermute=permute1(num, index-1);
//    	for (ArrayList<Integer> i:subPermute){
//    		for (int j=0;j<=i.size();j++){
//    			ArrayList<Integer> sub=new ArrayList<Integer>();
//    			for (int k=0;k<j;k++){
//    				sub.add(i.get(k));
//    			}
//    			sub.add(num[index]);
//    			for (int k=j;k<i.size();k++){
//    				sub.add(i.get(k));
//    			}
//    			result.add(sub);
//    		}
//    	}
//    	return result;
//    }
	
//    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
//        if (num.length==0) return result;
//        ArrayList<Integer> list=new ArrayList<Integer>();
//        list.add(num[0]);
//        result.add(list);
//        ArrayList<ArrayList<Integer>> listlist=new ArrayList<ArrayList<Integer>>();
//        for (int index=1;index<num.length;index++){
//	        for (ArrayList<Integer> i:result){
//	        	for (int j=0;j<=i.size();j++){
//		        	ArrayList<Integer> list1=new ArrayList<Integer>();
//	        		for (int k=0;k<j;k++) {
//	        			list1.add(i.get(k));
//	        		}
//	        		list1.add(num[index]);
//	        		for (int k=j;k<i.size();k++){
//	        			list1.add(i.get(k));
//	        		}
//	        		listlist.add(list1);
//	        	}
//	        }
//	        result=listlist;
//	        listlist=new ArrayList<ArrayList<Integer>>();
//        }
//        return result;
//    }
	
	    public List<List<Integer>> permute(int[] num) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        permuteRec(num,0,list);
	        return list;
	    }
	    
	    public void permuteRec(int[] num, int pos, List<List<Integer>> list){
	        if (pos >= num.length -1){
	        	ArrayList<Integer> num1 = new ArrayList<Integer>();
	        	for(int i:num) num1.add(i);
	        list.add(num1);
	        }
	        else{
	            for(int i=pos;i<num.length;i++){
	                swap(num, i, pos);
	                permuteRec(num,pos+1,list);
	                swap(num, i, pos);
	            }
	        }
	    }
	    
	    private void swap(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
    
    public static void main(String args[]){
    	Permutation s = new Permutation();
    	int[] num=new int[]{6,2,-1,8};
    	System.out.println(s.permute(num));
    }
}