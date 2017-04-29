import java.util.ArrayList;

public class PascalTriangle {
//    public ArrayList<ArrayList<Integer>> generate(int numRows) {
//        if (numRows==0) return new ArrayList<ArrayList<Integer>>();//input 0;
//        if (numRows==1) {
//            ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
//            ArrayList<Integer> onelist= new ArrayList<Integer>();
//            onelist.add(1);
//            list.add(onelist);
//            return list;
//        }
//        ArrayList<ArrayList<Integer>> sublist = generate(numRows-1);
//        ArrayList<Integer> lastRow = sublist.get(numRows-2);//numRows-1-1 is the position of last Row.
//        ArrayList<Integer> newRow = new ArrayList<Integer>();
//        newRow.add(1);
//        for (int i=0;i<lastRow.size()-1;i++) {
//            newRow.add(lastRow.get(i)+lastRow.get(i+1));
//        }
//        newRow.add(1);
//        sublist.add(newRow);
//        return sublist;
//    }//not good
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> listlist=new ArrayList<ArrayList<Integer>>();
        if (numRows==0) return listlist;
            ArrayList<Integer> list1=new ArrayList<Integer>(){{add(1);}};
            listlist.add(list1);
        // if (numRows==1) return listlist;
        for (int i=1;i<numRows;i++){
            list1=listlist.get(listlist.size()-1);
            ArrayList<Integer> list2=new ArrayList<Integer>(){{add(1);}};
            for (int j=1;j<list1.size();j++){
            	list2.add(list1.get(j)+list1.get(j-1));
            }
            list2.add(1);
            listlist.add(list2);
        }
//        int[] a=new int[]{1,2,3}; // array initialize;
        return listlist;
    }
}