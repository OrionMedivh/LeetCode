public class ValidNumber {
//	public boolean isNumber(String s) {
//		s = s.trim();
//
//		boolean pointSeen = false;
//		boolean eSeen = false;
//		boolean numberSeen = false;
//		boolean numberAfterE = true;
//		for (int i = 0; i < s.length(); i++) {
//			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//				numberSeen = true;
//				numberAfterE = true;
//			} else if (s.charAt(i) == '.') {
//				if (eSeen || pointSeen) {
//					return false;
//				}
//				pointSeen = true;
//			} else if (s.charAt(i) == 'e') {
//				if (eSeen || !numberSeen) {
//					return false;
//				}
//				numberAfterE = false;
//				eSeen = true;
//			} else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
//				if (i != 0 && s.charAt(i - 1) != 'e') {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		}
//
//		return numberSeen && numberAfterE;
//	}
    public boolean isNumber(String s) {
        //[-+]?[0-9]*(.[0-9]+)?(e[-+]?[0-9]+)?
        s = s.trim();
        
        boolean numberSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        
        for(int i =0; i < s.length();i++)
        switch(s.charAt(i)){
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
                if(eSeen || dotSeen) return false;
                dotSeen = true;
                break;
            case 'e':
                if(eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false;
                break;
            case '-':
            case '+':
                if(i!=0 && s.charAt(i-1) != 'e')
                return false;
                break;
            default:
                return false;
        }
        return numberSeen && numberAfterE;
    }
}
