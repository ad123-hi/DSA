1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int[] result = new int[]{-1, -1};
4        
5        result[0] = findBound(nums, target, true);
6        
7        // If the first bound doesn't exist, the target isn't in the array
8        if (result[0] != -1) {
9            result[1] = findBound(nums, target, false);
10        }
11        
12        return result;
13    }
14    //as linear search could not be implemented as in the q it is given to find O(logn) 
15    //so BINARY SEARCH
16    private int findBound(int[] nums, int target, boolean isFirst) {
17        int left = 0;
18        int right = nums.length - 1;
19        int bound = -1;
20        
21        while (left <= right) {
22            int mid = left + (right - left) / 2;
23            
24            if (nums[mid] == target) {
25                bound = mid; // Potential answer found
26                if (isFirst) {
27                    right = mid - 1; // Keep searching to the left
28                } else {
29                    left = mid + 1;  // Keep searching to the right
30                }
31            } else if (nums[mid] < target) {
32                left = mid + 1;
33            } else {
34                right = mid - 1;
35            }
36        }
37        
38        return bound;
39    }
40}