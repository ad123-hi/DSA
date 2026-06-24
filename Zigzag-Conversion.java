1class Solution {
2    public String convert(String s, int numRows) {
3        // Base case: If numRows is 1 or greater than/equal to the string length, 
4        // no zigzagging is needed, return the string as-is.
5        if (numRows == 1 || numRows >= s.length()) {
6            return s;
7        }
8
9        // Initialize a StringBuilder for each row to efficiently build strings
10        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
11        for (int i = 0; i < rows.length; i++) {
12            rows[i] = new StringBuilder();
13        }
14
15        int currRow = 0;
16        boolean goingDown = false;
17
18        // Iterate through each character in the string
19        for (char c : s.toCharArray()) {
20            rows[currRow].append(c);
21
22            // Toggle direction when we hit the top or bottom boundary
23            if (currRow == 0 || currRow == numRows - 1) {
24                goingDown = !goingDown;
25            }
26
27            // Move up or down to the next row based on direction
28            currRow += goingDown ? 1 : -1;
29        }
30
31        // Combine all rows into a single final String
32        StringBuilder result = new StringBuilder();
33        for (StringBuilder row : rows) {
34            result.append(row);
35        }
36
37        return result.toString();
38    }
39}
40