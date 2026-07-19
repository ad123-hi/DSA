import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];   // frequency of each char
        boolean[] inStack = new boolean[26]; // track if char is in stack
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--; // one occurrence used
            
            if (inStack[c - 'a']) continue; // skip if already in stack
            
            // maintain lexicographic order
            while (!stack.isEmpty() && stack.peekLast() > c && count[stack.peekLast() - 'a'] > 0) {
                inStack[stack.pollLast() - 'a'] = false;
            }
            
            stack.addLast(c);
            inStack[c - 'a'] = true;
        }
        
        // build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
