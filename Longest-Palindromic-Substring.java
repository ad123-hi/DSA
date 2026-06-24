1class Solution {
2    public String longestPalindrome(String s) {
3        if (s == null || s.length() < 1) return "";
4        
5        int start = 0;
6        int end = 0;
7        
8        for (int i = 0; i < s.length(); i++) {
9            // Case 1: Odd length palindromes (e.g., "aba", center is 'b')
10            int len1 = expandAroundCenter(s, i, i);
11            
12            // Case 2: Even length palindromes (e.g., "abba", center is between 'b' and 'b')
13            int len2 = expandAroundCenter(s, i, i + 1);
14            
15            // Get the maximum length found at this center position
16            int len = Math.max(len1, len2);
17            
18            // If we found a longer palindrome than our previous max, update the pointers
19            if (len > end - start) {
20                start = i - (len - 1) / 2;
21                end = i + len / 2;
22            }
23        }
24        
25        // Return the longest substring found
26        return s.substring(start, end + 1);
27    }
28    
29    private int expandAroundCenter(String s, int left, int right) {
30        // Expand outwards as long as the characters match and we are within bounds
31        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
32            left--;
33            right++;
34        }
35        // Return the length of the valid palindrome found
36        // (right - left - 1) handles the final out-of-bounds/mismatched step
37        return right - left - 1;
38    }
39}