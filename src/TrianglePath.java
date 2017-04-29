import java.util.ArrayList;

public class TrianglePath {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size()==0) return 0;
        if (triangle.size()==1) return triangle.get(0).get(0);
        ArrayList<Integer> lastresult=new ArrayList<Integer>(triangle.get(0));
        for (int i=1;i<triangle.size();i++){
        	ArrayList<Integer> currentline=triangle.get(i);
        	ArrayList<Integer> newresult=new ArrayList<Integer>();
        	newresult.add(lastresult.get(0)+currentline.get(0));
        	for (int j=1;j<currentline.size()-1;j++){//from 1 to n-2;
        		newresult.add(Math.min(lastresult.get(j-1),lastresult.get(j))+currentline.get(j));
        	}
        	newresult.add(lastresult.get(lastresult.size()-1)+currentline.get(currentline.size()-1));
        	lastresult=newresult;
        }
        int min=lastresult.get(0);
        for (int i:lastresult){
        	if (i<min)
        		min=i;
        }
        return min;
    }
}