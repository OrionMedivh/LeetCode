public class ValidNumber {
	public boolean isNumber(String s) {
		/*
		 * //? :zero or one //* :one or more //+ :zero or more
		 * 
		 * We start with trimming.
		 * 
		 * If we see [0-9] we reset the number flags. We can only see . if we
		 * didn't see e or .. We can only see e if we didn't see e but we did
		 * see a number. We reset numberAfterE flag. We can only see + and - in
		 * the beginning and after an e any other character break the
		 * validation. At the and it is only valid if there was at least 1
		 * number and if we did see an e then a number after it as well.
		 * 
		 * So basically the number should match this regular expression:
		 * 
		 * [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
		 */
		s = s.trim();
		boolean pointSeen = false, eSeen = false, numSeen = false, numAfterE = false;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				numSeen = true;
				numAfterE = true;
			} else if (ch == '.') {
				if (eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			} else if (ch == 'e') {
				if (eSeen || !numSeen) {
					return false;
				}
				numAfterE = false;
				eSeen = true;
			} else if (ch == '-' || ch == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return numSeen && numAfterE;
	}

	public boolean isNumber2(String s) {
		s = s.trim();

		boolean numberSeen = false;
		boolean dotSeen = false;
		boolean eSeen = false;
		boolean numberAfterE = true;

		for (int i = 0; i < s.length(); i++)
			switch (s.charAt(i)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				numberSeen = true;
				numberAfterE = true;
				break;
			case '.':
				if (eSeen || dotSeen)
					return false;
				dotSeen = true;
				break;
			case 'e':
				if (eSeen || !numberSeen)
					return false;
				eSeen = true;
				numberAfterE = false;
				break;
			case '-':
			case '+':
				if (i != 0 && s.charAt(i - 1) != 'e')
					return false;
				break;
			default:
				return false;
			}
		return numberSeen && numberAfterE;
	}
}
