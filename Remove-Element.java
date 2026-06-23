1class Solution {
2    public int removeElement(int[] nums, int val) {
3        int k = 0; // Pointer for the next valid element position
4        
5        for (int i = 0; i < nums.length; i++) {
6            // If the current element is NOT the value we want to remove
7            if (nums[i] != val) {
8                nums[k] = nums[i]; // Move it to the front
9                k++; // Move the valid pointer forward
10            }
11        }
12        
13        return k; // k is the count of elements not equal to val
14    }
15}