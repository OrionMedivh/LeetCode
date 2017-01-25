import java.util.HashMap;

public class FlipGameII {
	// public boolean canWin(String s) {
	// String[] s1= s.substring(0, s.length()).split("-");
	// int n = 0;
	// for(String s2 : s1) n=Math.max(s2.length()+1, n);
	// boolean[] win = new boolean[n];
	// for (int i =0; i<n;i++){
	// if (i < 2) win[i] = false;
	// if (i == 2) win[i] = true;
	// for(int j=0;j < i/2 ; j++){
	// win[i]=win[i] || ((j==0?true:!win[j])&&!win[i-j-2] ||
	// (j==0?false:win[j])&&win[i-j-2]);
	// }
	// }
	// boolean win1 = false;
	// for(String s2: s1) win1 = win1|| win[s2.length()];
	// return win1;
	// } //wrong

	// public boolean canWin(String s) {
	// s = s.replace('-', ' ');
	// int result = 0;
	// List<Integer> dp = new ArrayList<>();
	// for (String substring : s.split("[ ]+")) {
	// int length = substring.length();
	// if (length == 0) continue;
	// while (dp.size() <= length) {
	// char[] subarray = substring.toCharArray();
	// int i = 0, j = dp.size() - 2;
	// while (i <= j)
	// subarray[dp.get(i++) ^ dp.get(j--)] = '-';
	// dp.add(new String(subarray).indexOf('+'));
	// }
	// result ^= dp.get(length);
	// }
	// return result != 0;
	// } //some fancy algorithm, don't understand

	private HashMap<String, Boolean> map = new HashMap<>();
	
	public boolean canWin(String s) {
		if(s.length()<2) return false;
		if(map.containsKey(s)) return map.get(s);
		for(int i=0;i<s.length()-1;i++){
			if(s.substring(i,i+2).equals("++")){
				StringBuffer flipped = new StringBuffer();
				flipped.append(s.substring(0,i));
				flipped.append("--");
				flipped.append(s.substring(i+2));
				if(!canWin(flipped.toString())){
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
}