import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateRemoval {

    private static List<Character> excludedChars = List.of
            ('!', '?', '{', '}', '[', ']', '(', ')', ',', '.', '-', ':', ';');

    /**
     * Passing a text with duplicates into this function will return
     * a {@code String} where each word is appearing at most once.
     */
    public static String removeDuplicates(String str) {
        Map<String, Integer> wordCount = new HashMap<>();
        Scanner scanner = new Scanner(str);

        StringBuilder noDuplicates = new StringBuilder("");
        while (scanner.hasNext()) {
            String next = scanner.next();
            String pureWord = getPureWord(next);
            if (wordCount.containsKey(pureWord)) {
                continue;
            }
            wordCount.put(pureWord, 1);
            noDuplicates.append(next + " ");
        }
        return noDuplicates.deleteCharAt(noDuplicates.length() - 1).toString();
    }

    /**
     * Returns a 'distilled' form of string provided on input.
     * Distilled, in this context, means a pure, dictionary word i.e.
     * without commas, parentheses, in lowercase, etc.
     * Characters that get removed: ['!', '?', '{', '}', '[', ']', '(', ')', ',', '.', '-', ':', ';']
     */
    private static String getPureWord(String word) {
        StringBuilder sb = new StringBuilder(word.toLowerCase());
        if (excludedChars.contains(word.charAt(0))) {
            sb.deleteCharAt(0);
        }
        int lastIndex = sb.length() - 1;
        if (lastIndex >= 0 && excludedChars.contains(word.charAt(lastIndex))) {
            sb.deleteCharAt(lastIndex);
        }
        return sb.toString();
    }
}
