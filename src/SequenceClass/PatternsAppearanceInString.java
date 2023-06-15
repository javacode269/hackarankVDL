package SequenceClass;
import java.util.*;

class AhoCorasickNode {
    //public static final int ALPHABET_SIZE = ;
    public static final int ALPHABET_SIZE = 26;

    public AhoCorasickNode[] children;
    public List<Integer> output;
    public AhoCorasickNode failure;

    public AhoCorasickNode() {
        children = new AhoCorasickNode[ALPHABET_SIZE];
        output = new ArrayList<>();
        failure = null;
    }
}

public class PatternsAppearanceInString {
    private AhoCorasickNode root;

    public PatternsAppearanceInString() {
        root = new AhoCorasickNode();
    }

    public void addPattern(String pattern, int patternIndex) {
        AhoCorasickNode node = root;

        for (char c : pattern.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new AhoCorasickNode();
            }

            node = node.children[index];
        }

        node.output.add(patternIndex);
    }

    public void buildFailureLinks() {
        Queue<AhoCorasickNode> queue = new LinkedList<>();

        for (int i = 0; i < AhoCorasickNode.ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                root.children[i].failure = root;
                queue.add(root.children[i]);
            }
        }

        while (!queue.isEmpty()) {
            AhoCorasickNode currentNode = queue.poll();

            for (int i = 0; i < AhoCorasickNode.ALPHABET_SIZE; i++) {
                AhoCorasickNode childNode = currentNode.children[i];

                if (childNode != null) {
                    queue.add(childNode);

                    AhoCorasickNode failureNode = currentNode.failure;

                    while (failureNode.children[i] == null && failureNode != root) {
                        failureNode = failureNode.failure;
                    }

                    if (failureNode.children[i] != null) {
                        failureNode = failureNode.children[i];
                    }

                    childNode.failure = failureNode;

                    childNode.output.addAll(failureNode.output);
                }
            }
        }
    }

    public List<MatchResult> search(String text, String[] patterns) {
        List<MatchResult> result = new ArrayList<>();
        AhoCorasickNode currentNode = root;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = c - 'a';

            while (currentNode.children[index] == null && currentNode != root) {
                currentNode = currentNode.failure;
            }

            if (currentNode.children[index] != null) {
                currentNode = currentNode.children[index];

                for (int patternIndex : currentNode.output) {
                    String pattern = patterns[patternIndex];
                    int startPosition = i - pattern.length() + 1;
                    MatchResult matchResult = new MatchResult(pattern, startPosition);
                    result.add(matchResult);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "abababcd";
        String[] patterns = {"ab", "bc", "cd"};

        PatternsAppearanceInString patternsAppearanceInString = new PatternsAppearanceInString();

        for (int i = 0; i < patterns.length; i++) {
            patternsAppearanceInString.addPattern(patterns[i], i);
        }

        patternsAppearanceInString.buildFailureLinks();

        List<MatchResult> matchResults = patternsAppearanceInString.search(text, patterns);

        for (MatchResult matchResult : matchResults) {
            System.out.println("Pattern: " + matchResult.getPattern() + ", Start Position: " + matchResult.getStartPosition());
        }
    }
}

class MatchResult {
    private String pattern;
    private int startPosition;

    public MatchResult(String pattern, int startPosition) {
        this.pattern = pattern;
        this.startPosition = startPosition;
    }

    public String getPattern() {
        return pattern;
    }

    public int getStartPosition() {
        return startPosition;
    }
}
