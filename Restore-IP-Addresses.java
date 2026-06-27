1class Solution {
2    public List<String> restoreIpAddresses(String s) {
3        List<String> result = new ArrayList<>();
4        backtrack(result, new ArrayList<>(), s, 0);
5        return result;
6    }
7
8    private void backtrack(List<String> result, List<String> path, String s, int start) {
9        // If we already have 4 parts and consumed all characters, it's a valid IP
10        if (path.size() == 4 && start == s.length()) {
11            result.add(String.join(".", path));
12            return;
13        }
14        // If we have 4 parts but still characters left, invalid
15        if (path.size() == 4) return;
16
17        // Try segments of length 1 to 3
18        for (int len = 1; len <= 3; len++) {
19            if (start + len > s.length()) break;
20            String segment = s.substring(start, start + len);
21
22            // Validate segment
23            if (isValid(segment)) {
24                path.add(segment);
25                backtrack(result, path, s, start + len);
26                path.remove(path.size() - 1); // backtrack
27            }
28        }
29    }
30
31    private boolean isValid(String segment) {
32        // No leading zeros unless the segment is "0"
33        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
34        int val = Integer.parseInt(segment);
35        return val >= 0 && val <= 255;
36    }
37}
38