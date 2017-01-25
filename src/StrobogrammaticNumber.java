import java.util.HashMap;

public class StrobogrammaticNumber {
//    public boolean isStrobogrammatic(String num) {
//    	HashMap<Character, Character> map = new HashMap<Character, Character>();
//    	map.put('1', '1');
//    	map.put('6', '9');
//    	map.put('9', '6');
//    	map.put('8', '8');
//    	map.put('0', '0');
//        	int n = num.length();
//        	if (n % 2 == 1) {
//        		char mid = num.charAt(n/2);
//        		if ( mid != '1' && mid !='8' && mid!= '0'){
//        			return false;
//        		}
//        	}
//        	for (int i =0;i<n/2;i++){
//        		if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i))!=num.charAt(n-1-i)){
//        			return false;
//        		}
//        	}
//    	return true;
//    }
    
    public boolean isStrobogrammatic(String num) {
      HashMap<Character, Character> map = new HashMap<Character, Character>();
      map.put('1', '1');
      map.put('6', '9');
      map.put('9', '6');
      map.put('8', '8');
      map.put('0', '0');
          int n = num.length();
          int i = 0, j = n-1;
          while(i<=j){
            if(!map.containsKey( num.charAt( i ) ) || map.get( num.charAt( i ) ) != num.charAt( j ) ){
              return false;
            }
            i++;
            j--;
          }
      return true;
    }
    
    
    public static void main(String[] args){
    StrobogrammaticNumber s = new StrobogrammaticNumber();
    System.out.println(s.isStrobogrammatic("2"));
    System.out.println(s.isStrobogrammatic("123"));
    System.out.println(s.isStrobogrammatic("69"));
    System.out.println(s.isStrobogrammatic("818"));
    System.out.println(s.isStrobogrammatic("88"));
    System.out.println(s.isStrobogrammatic("110"));
    System.out.println(s.isStrobogrammatic("1"));
    System.out.println(s.isStrobogrammatic("25"));
    }
}