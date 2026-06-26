1import java.util.ArrayList;
2import java.util.HashMap;
3import java.util.List;
4import java.util.Map;
5//do this question again as you have not got the concept of it
6class Solution {
7    public List<Integer> findSubstring(String s, String[] words) {
8        List<Integer> result = new ArrayList<>();
9        if (s == null || s.length() == 0 || words == null || words.length == 0) {
10            return result;
11        }
12        
13        Map<String, Integer> wordCount = new HashMap<>();
14        for (String word : words) {
15            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
16        }
17        
18        int wordLen = words[0].length();
19        int totalWords = words.length;
20        int totalLen = wordLen * totalWords;
21        
22        for (int i = 0; i < wordLen; i++) {
23            int left = i;
24            int right = i;
25            Map<String, Integer> currentCount = new HashMap<>();
26            int count = 0;
27            
28            while (right + wordLen <= s.length()) {
29                String word = s.substring(right, right + wordLen);
30                right += wordLen;
31                
32                if (wordCount.containsKey(word)) {
33                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
34                    count++;
35                    
36                    while (currentCount.get(word) > wordCount.get(word)) {
37                        String leftWord = s.substring(left, left + wordLen);
38                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
39                        count--;
40                        left += wordLen;
41                    }
42                    
43                    if (count == totalWords) {
44                        result.add(left);
45                    }
46                } else {
47                    currentCount.clear();
48                    count = 0;
49                    left = right;
50                }
51            }
52        }
53        
54        return result;
55    }
56}