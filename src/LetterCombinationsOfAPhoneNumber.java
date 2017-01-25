import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
    private char [][] map={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
        };
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<String>();
        if(digits.equals("")) return result;
        StringBuffer sb=new StringBuffer();
        combinations(digits,0,sb,result);
        return result;
    } 
    public void combinations(String digits, int index, StringBuffer sb, ArrayList<String> result){
        if(index>=digits.length()){
            result.add(sb.toString());
        }
        else{
            int i=digits.charAt(index)-'1'-1; //get row; '2'-'1'-1=0;
            for (char c:map[i]){
                sb.append(c);
                combinations(digits,index+1,sb,result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}