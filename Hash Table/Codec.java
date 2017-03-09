public class Codec {
    // To design a codec; basic idea is to implement a hashmap of string and string
    // Encodes a URL to a shortened URL.
    Map<String, String> hashMap = new HashMap<>();
    public String encode(String longUrl) {
        String s = Integer.toString(hashMap.size());
        hashMap.put(s, longUrl);
        return s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String s = hashMap.get(shortUrl);
        return s;
    }
}
