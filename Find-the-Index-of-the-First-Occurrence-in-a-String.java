1class Solution {
2    public int strStr(String haystack, String needle) {
3        int hLen = haystack.length();
4        int nLen = needle.length();
5        //in this question this is the base case that if the lenght opf the heystack is lesser
6        //then it cannnot be found in needle
7        if (nLen > hLen) {
8            return -1;
9        }
10        
11        for (int i = 0; i <= hLen - nLen; i++) {
12            if (haystack.substring(i, i + nLen).equals(needle)) {
13                return i;
14            }
15        }
16        
17        return -1;
18    }
19}