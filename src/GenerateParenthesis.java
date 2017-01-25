import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
//    public ArrayList<String> generateParenthesis(int n) {
//        ArrayList<String> result=new ArrayList<String>();
//        if (n==0) return result;
//        if (n==1) {
//            String temp="()";
//            result.add(temp);
//            return result;
//        }
//        HashSet<String> res=new HashSet<String>();
//        ArrayList<String> subResult=generateParenthesis(n-1);
//        for (String s: subResult){
//            for (int i=0;i<n;i++){//2(n-1)/2+1; insert position is half of the subresult.
//                StringBuffer sb=new StringBuffer();
//                sb.append(s.substring(0,i));//subString not include end;
//                sb.append("()");
//                sb.append(s.substring(i,s.length()));//not include end,so s,length()-1+1
//                res.add(sb.toString());
//            }
//        }
//        for (String i:res){
//        	result.add(i);
//        }
//        return result;
//    }
	
//    public ArrayList<String> generateParenthesis(int n) {
//        ArrayList<String> list=new ArrayList<String>();
//        if(n==0) return list;
//    	list.add("()");
//    	if (n==1) return list;
//        for(int i=2;i<=n;i++){
//            HashSet<String> set=new HashSet<String>();
//            for(String s:list){
//                for (int j=0;j<i;j++){//2(i-1)/2+1; insert position is half of the subresult.
//                StringBuffer sb=new StringBuffer();
//                sb.append(s.substring(0,j));
//                sb.append("()");
//                sb.append(s.substring(j,s.length()));
//                set.add(sb.toString());
//                }
//            }
//            list=new ArrayList<String>();
//            for(String str:set) list.add(str);
//        }
//        return list;
//    }
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesis(n,n, "", result);
        return result;
    }
    
    public void generateParenthesis(int open, int close, String x, List<String> result){
        if (open == 0 && close == 0){ 
        result.add(x);
        return;
        }
        if (open > 0)
            generateParenthesis(open-1, close, x+"(", result);
        if (close > open)
            generateParenthesis(open, close -1, x+")", result);
    }
}