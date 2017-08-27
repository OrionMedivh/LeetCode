import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
	private Map<String, String> index = new HashMap<>();
	private Map<String, String> revIndex = new HashMap<String, String>();
	private final String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (revIndex.containsKey(longUrl))
			return revIndex.get(longUrl);
		String key = null;
		do {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 6; i++) {
				int r = (int) (Math.random() * charSet.length());
				sb.append(charSet.charAt(r));
			}
			key = sb.toString();
		} while (index.containsKey(key));
		index.put(longUrl, key);
		revIndex.put(key, longUrl);
		return key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if (revIndex.containsKey(shortUrl)) {
			return revIndex.get(shortUrl);
		}
		return "";
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));