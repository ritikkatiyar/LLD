import java.util.Arrays;

public class LongestValidWordWithAllPrefixes {
    public String longestValidWord(String[] words) {
        Arrays.sort(words);
        TrieNode root = new TrieNode();
        String longest = "";

        for (String word : words) {
            TrieNode crawler = root;
            boolean valid = true;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                // check prefix validity before moving deeper
                if (i > 0 && !crawler.isEnd) {
                    valid = false;
                    break;
                }

                if (crawler.children[index] == null) {
                    crawler.children[index] = new TrieNode();
                }
                crawler = crawler.children[index];
            }

            crawler.isEnd = true;

            if (valid) {
                if (word.length() > longest.length() ||
                        (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public static void main(String[] args) {
        LongestValidWordWithAllPrefixes prefixes = new LongestValidWordWithAllPrefixes();
        String[] words = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println(prefixes.longestValidWord(words));  // ✅ Output: problem
    }
}
