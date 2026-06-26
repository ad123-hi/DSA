1class Solution {
2    public int romanToInt(String s) {
3        int total = 0;
4        int prevValue = 0;
5        
6        for (int i = s.length() - 1; i >= 0; i--) {
7            int currentValue = 0;
8            switch (s.charAt(i)) {
9                case 'I': currentValue = 1; break;
10                case 'V': currentValue = 5; break;
11                case 'X': currentValue = 10; break;
12                case 'L': currentValue = 50; break;
13                case 'C': currentValue = 100; break;
14                case 'D': currentValue = 500; break;
15                case 'M': currentValue = 1000; break;
16            }
17            
18            if (currentValue < prevValue) {
19                total -= currentValue;
20            } else {
21                total += currentValue;
22            }
23            
24            prevValue = currentValue;
25        }
26        
27        return total;
28    }
29}