1class Solution {
2    public int maxArea(int[] height) {
3        int maxWater = 0;
4        int left = 0;
5        int right = height.length - 1;
6        
7        while (left < right) {
8            // Calculate the width between the two pointers
9            int width = right - left;
10            
11            // Calculate the current water area
12            int currentHeight = Math.min(height[left], height[right]);
13            int currentWater = width * currentHeight;
14            
15            // Update the maximum water found so far
16            maxWater = Math.max(maxWater, currentWater);
17            
18            // Move the pointer pointing to the shorter line inward
19            if (height[left] < height[right]) {
20                left++;
21            } else {
22                right--;
23            }
24        }
25        
26        return maxWater;
27    }
28}