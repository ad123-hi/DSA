class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move in s when match found
            }
            j++; // always move in t
        }

        return i == s.length(); // all chars in s matched
    }
}
