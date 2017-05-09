import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int i = 0, currLineWords, wordsLength;
		while (i < words.length) {
			currLineWords = 0;
			wordsLength = 0;
			while (i + currLineWords < words.length
					&& (wordsLength += words[i + currLineWords++].length() + 1) <= maxWidth) {
			}
			StringBuffer temp = new StringBuffer(words[i]);
			StringBuffer spaces = new StringBuffer();

		}
	}
}
