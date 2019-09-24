package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        codec.decode(codec.encode(url));
    }
}

// I programmed this by myself.
class Codec {

    // Example:
    // Key: https://leetcode.com/problems/design-tinyurl
    // Value: http://tinyurl.com/4e9iAk
    Map<String, String> map = new HashMap<>();

    int num = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = "http://tinyurl.com/" + this.num++;
        map.put(longUrl, encoded);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(shortUrl)) {
                key = entry.getKey();
                break;
            }
        }
        return key; // DNE
    }
}

class AnotherCodec {
    private static Map<String, String> map = new HashMap<>();

    public static String encode(String longUrl) {
        String lS = Integer.toHexString(longUrl.hashCode());
        map.put(lS, longUrl);
        return lS;
    }
    public static String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}