package LeetCode.Hard;

import java.util.*;

class TrieNode {
    int pos; // this tell the trie that "abc" is an existing word in the beginning array.
    TrieNode[] nodes;
    List<Integer> palindromes;

    TrieNode() {
        nodes = new TrieNode[26]; // 26 characters in the english alphabet.
        pos = -1;
        palindromes = new ArrayList<>();
    }
}

public class PalindromePairs {
    public static void main(String[] args) {
        String[] words1 = {"cbaaa", "bc", "abc"};
        List<List<Integer>> ans1 = anotherSolution(words1);
        printNestedList(ans1);

//        String[] words2 = {"abcd","dcba","lls","s","sssll"};
//        List<List<Integer>> ans2 = anotherSolution(words2);
//        printNestedList(ans2);
    }

    // This uses the Trie data structure.
    // Time Complexity: O(N^2 * K), where N = words.length; and K = average length of each word.
    public static List<List<Integer>> anotherSolution(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
            addWord(root, words[i], i); // this builds the tree structure.

        for (int i = 0; i < words.length; i++)
            search(words, i, root, res); // this searches for palindromes in the array.
        return res;
    }

    // adds the word to the TrieNode in reversed order.
    private static void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; --i) { // reversed order
            int j = word.charAt(i) - 'a'; // 'a' - 'a' = 0, 'b' - 'a' = 1, 'c' - 'a' = 2.

            if (root.nodes[j] == null) { // if the indexed node is null
                root.nodes[j] = new TrieNode(); // create a new node
            }

            if (isPalindrome(word, 0, i)) {
                root.palindromes.add(index);
            }

            root = root.nodes[j];
        }

        root.palindromes.add(index);
        root.pos = index;
    }

    private static void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.pos >= 0 && root.pos != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.pos));
            }

            root = root.nodes[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.palindromes) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    public static boolean isPalindrome(String word, int i, int j) {
        while (i < j) { // while the left pointer is less than the right pointer
            if (word.charAt(i++) != word.charAt(j--)) // if they're not the same character
                return false;
        }
        return true;
    }

    // mine works, but it's just too damn slow.
    // Time Complexity: O(N^2), where N is words.length;
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; ++i) // put each string and the index into a hashmap
            map.put(words[i], i);

        for (int r = 0; r < words.length; ++r) {
            for (int c = 0; c < words.length; ++c) {
                if (r != c) {
                    List<Integer> indices = new ArrayList<>();
                    if (isPalindrome(words[r], words[c])) {
                        indices.add(r);
                        indices.add(c);
                        if (!pairs.contains(indices)) {
                            pairs.add(indices);
                        }
                    }
                }
            }
        }

        return pairs;
    }

    public static boolean isPalindrome(String a, String b) {
        String concat = a + b;
        int i = 0, j = concat.length() - 1;
        while (i < j) {
            if (concat.charAt(i++) != concat.charAt(j--))
                return false;
        }
        return true;
    }

    public static void printNestedList(List<List<Integer>> nestedList) {
        for (List<Integer> a : nestedList) {
            printList(a);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}