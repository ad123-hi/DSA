1class Solution {
2    public int lengthOfLastWord(String s) {
3        int length = 0;
4        int i = s.length() - 1;
5        
6        // Step 1: Skip all trailing spaces
7        while (i >= 0 && s.charAt(i) == ' ') {
8            i--;
9        }
10        //here the i value will become the first index of the lastword
11        // Step 2: Count characters of the last word
12        while (i >= 0 && s.charAt(i) != ' ') {
13            length++;
14            i--;
15        }
16        
17        return length;
18    }
19}