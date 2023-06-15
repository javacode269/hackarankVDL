package SequenceClass;

import java.util.ArrayList;
import java.util.List;

public class AhoCorasick {
    public static class TrieNode {
        private static final int ALPHABET_SIZE = 26;

        private TrieNode[] children;
        private boolean isEndOfWord;
        private TrieNode failureLink;
        private List<Integer> output;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
            failureLink = null;
            output = new ArrayList<>();
        }
    }

    public static class ACAutomaton {
        private static final int ALPHABET_SIZE = 26;
        private TrieNode root;

        public ACAutomaton() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEndOfWord = true;
        }

        public void constructFailureLinks() {
            TrieNode current = root;
            current.failureLink = null;

            List<TrieNode> nodesQueue = new ArrayList<>();

            for (TrieNode child : current.children) {
                if (child != null) {
                    child.failureLink = current;
                    nodesQueue.add(child);
                }
            }

            while (!nodesQueue.isEmpty()) {
                TrieNode node = nodesQueue.remove(0);

                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    TrieNode child = node.children[i];

                    if (child != null) {
                        nodesQueue.add(child);

                        TrieNode failureLink = node.failureLink;

                        while (failureLink != null && failureLink.children[i] == null) {
                            failureLink = failureLink.failureLink;
                        }

                        child.failureLink = failureLink != null ? failureLink.children[i] : root;

                        child.output.addAll(child.failureLink.output);
                        if (child.isEndOfWord) {
                            child.output.add(child.failureLink.output.size());
                        }
                    }
                }
            }
        }

        public List<Integer> search(String text) {
            List<Integer> occurrences = new ArrayList<>();

            TrieNode current = root;

            for (int i = 0; i < text.length(); i++) {
                int index = text.charAt(i) - 'a';

                while (current != null && current.children[index] == null) {
                    current = current.failureLink;
                }

                if (current == null) {
                    current = root;
                } else {
                    current = current.children[index];

                    if (current.isEndOfWord) {
                        occurrences.addAll(current.output);
                    }
                }
            }

            return occurrences;
        }
    }

    public static void main(String[] args) {
        ACAutomaton acAutomaton = new ACAutomaton();
        acAutomaton.insert("he");
        acAutomaton.insert("she");
        acAutomaton.insert("his");
        acAutomaton.insert("hers");

        acAutomaton.constructFailureLinks();

        String text = "ushers";
        List<Integer> occurrences = acAutomaton.search(text);

        if (!occurrences.isEmpty()) {
            System.out.println("Pattern found at indexes:");
            for (int index : occurrences) {
                System.out.println(index);
            }
        } else {
            System.out.println("Pattern not found");
        }
    }
}

