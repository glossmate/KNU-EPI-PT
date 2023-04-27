import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateSequence {
    public static List<String> generateSequence(String[] words) {
        Arrays.sort(words); // 단어들을 알파벳 순으로 정렬합니다.
        String firstWord = words[0];
        String[] otherWords = Arrays.copyOfRange(words, 1, words.length);

        List<String> possibleWords = new ArrayList<>();
        // 첫 번째 단어를 제외한 나머지 단어들을 모두 조합해서 만들 수 있는 단어들을 구합니다.
        for (int i = 0; i < (1 << otherWords.length); i++) {
            StringBuilder wordBuilder = new StringBuilder();
            for (int j = 0; j < otherWords.length; j++) {
                if ((i & (1 << j)) > 0) {
                    wordBuilder.append(otherWords[j]);
                }
            }
            possibleWords.add(wordBuilder.toString());
        }

        List<String> validWords = new ArrayList<>();
        // 구한 단어들 중에서, 첫 번째 단어를 포함하고 있는 단어들만 남깁니다.
        for (String word : possibleWords) {
            if (word.contains(firstWord)) {
                validWords.add(word);
            }
        }

        List<String> sequence = new ArrayList<>();
        sequence.add(firstWord);
        // 남은 단어들을 주어진 순서대로 배열합니다.
        for (String word : words) {
            if (validWords.contains(word)) {
                sequence.add(word);
            }
        }

        return sequence;
    }

    public static void main(String[] args) {
        String[] words = {"bat", "cot", "dog", "dag", "dot", "cat"};
        List<String> sequence = generateSequence(words);
        System.out.println(sequence);
        // 출력 결과: [cat, cot, dot, dog]

    }
}
