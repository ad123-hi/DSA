1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3       int[] hash = new int[256];
4        Arrays.fill(hash, -1);
5        
6        int l = 0;
7        int r = 0;
8        int maxLen = 0;
9        
10        
11        while (r < s.length()) {
12            char currentChar = s.charAt(r);
13            
14   
15            if (hash[currentChar] != -1) {
16             
17                if (hash[currentChar] >= l) {
18                    l = hash[currentChar] + 1;
19                }
20            }
21
22            int len = r - l + 1;
23            maxLen = Math.max(len, maxLen);
24         
25            hash[currentChar] = r;
26            r++;
27        }
28        
29        return maxLen;
30    }
31}