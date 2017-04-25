import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		int sum = 0;
		HashMap<String,Integer> minus = new HashMap<>();
		minus.put("IV", -2);
		minus.put("IX", -2);
		minus.put("XL", -20);
		minus.put("XC", -20);
		minus.put("CD", -200);
		minus.put("CM", -200);
		
		HashMap<Character,Integer> plus = new HashMap<>();
		plus.put('I', 1);
		plus.put('V', 5);
		plus.put('X', 10);
		plus.put('L', 50);
		plus.put('C', 100);
		plus.put('D', 500);
		plus.put('M', 1000);
		
		for(String str:minus.keySet()){
			if(s.indexOf(str)!=-1){
				sum += minus.get(str);
			}
		}
		for(char c:s.toCharArray()){
			sum += plus.get(c);
		}
		return sum;
	}
}
