1class Solution {
2    public int[] plusOne(int[] digits) {
3        for (int i = digits.length - 1; i >= 0; i--) {
4            // If the current digit is less than 9, just increment it and return
5            if (digits[i] < 9) {
6                digits[i]++;
7                return digits;
8            }
9            
10            // If it is 9, it becomes 0 (carry over to the next left digit)
11            digits[i] = 0;
12        }
13        
14        // If the loop finishes, it means all digits were 9 (e.g., [9, 9, 9] -> [0, 0, 0])
15        // We need a new array with an extra length of 1, starting with a 1.
16        int[] newDigits = new int[digits.length + 1];
17        newDigits[0] = 1;
18        return newDigits;
19    }
20}