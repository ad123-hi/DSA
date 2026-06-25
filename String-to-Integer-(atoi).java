1class Solution {
2    public int myAtoi(String s) {
3        // Handle empty or null string edge case
4        if (s == null || s.length() == 0) {
5            return 0;
6        }
7
8        int i = 0;
9        int n = s.length();
10        int sign = 1;
11        int result = 0;
12
13        // 1. Discard leading whitespaces
14        while (i < n && s.charAt(i) == ' ') {
15            i++;
16        }
17
18        // 2. Check for optional sign
19        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
20            if (s.charAt(i) == '-') {
21                sign = -1;
22            }
23            i++; // Move pointer past the sign
24        }
25
26        // 3. Convert characters to integer and handle overflow
27        while (i < n && Character.isDigit(s.charAt(i))) {
28            int digit = s.charAt(i) - '0';
29
30            // Check for potential overflow before updating result
31            if (result > Integer.MAX_VALUE / 10 || 
32               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
33                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
34            }
35
36            result = result * 10 + digit;
37            i++;
38        }
39
40        return result * sign;
41    }
42}