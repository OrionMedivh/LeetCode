
public class IntegerToEnglishWords {

	private final String[] LESS_THAN_20 = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	private final String[] TENS = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };
	private final String[] THOUSANDS = new String[] { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int n) {
		long num = n;
		if (num == 0) {
			return "Zero";
		}
		int i = 0;
		StringBuffer res = new StringBuffer();

		while (num > 0) {
			if (num % 1000 != 0) {
				res.insert(0, " ");
				res.insert(0, THOUSANDS[i]);
				res.insert(0, numberToWordsHelper(num % 1000));
			}
			num /= 1000;
			i++;
		}
		return res.toString().trim();
	}

	private StringBuffer numberToWordsHelper(long num) {
		StringBuffer sb = new StringBuffer();
		if (num == 0) {
		} else if (num < 20) {
			sb.append(LESS_THAN_20[(int) num]);
			sb.append(" ");
		} else if (num < 100) {
			sb.append(TENS[(int) (num / 10)]);
			sb.append(" ");
			sb.append(numberToWordsHelper(num % 10));
		} else {
			sb.append(LESS_THAN_20[(int) (num / 100)]);
			sb.append(" Hundred ");
			sb.append(numberToWordsHelper(num % 100));
		}
		return sb;
	} // don't like this answer, maybe rewrite in seperate function like
		// resolveLessThanTwenty, resolveLessThanHundred,
		// resolveLessThanThousand
}
