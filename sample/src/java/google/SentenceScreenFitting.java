package google;

/**
 * Created by junm5 on 12/27/16.
 */
public class SentenceScreenFitting {
    /**
     * Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.
     * <p>
     *
     * Note:
     * <p>
     * A word cannot be split into two lines.
     * The order of words in the sentence must remain unchanged.
     * Two consecutive words in a line must be separated by a single space.
     * Total words in the sentence won't exceed 100.
     * Length of each word won't exceed 10.
     * 1 ≤ rows, cols ≤ 20,000.
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    public static void main(String[] args) {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();

        sentenceScreenFitting.wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6);

    }
}
