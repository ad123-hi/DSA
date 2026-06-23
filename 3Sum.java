1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> threeSum(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        
9        Arrays.sort(nums);
10        
11        // Step 2: Iterate through the array fixing the first element
12        for (int i = 0; i < nums.length - 2; i++) {
13            // Optimization: If the current number is greater than 0, 
14            // any numbers after it will also be > 0. Three positive numbers can't sum to 0.
15            if (nums[i] > 0) {
16                break;
17            }
18            
19            // Skip duplicate values for the first element to avoid duplicate triplets
20            if (i > 0 && nums[i] == nums[i - 1]) {
21                continue;
22            }
23            
24            // Step 3: Two-pointer approach for the remaining two elements
25            int left = i + 1;
26            int right = nums.length - 1;
27            
28            while (left < right) {
29                int sum = nums[i] + nums[left] + nums[right];
30                
31                if (sum == 0) {
32                    // Found a valid triplet
33                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
34                    
35                    // Move pointers and skip duplicates for the left and right elements
36                    while (left < right && nums[left] == nums[left + 1]) {
37                        left++;
38                    }
39                    while (left < right && nums[right] == nums[right - 1]) {
40                        right--;
41                    }
42                    
43                    // Standard move after finding a match
44                    left++;
45                    right--;
46                    
47                } else if (sum < 0) {
48                    // Sum is too small, move left pointer to increase the sum
49                    left++;
50                } else {
51                    // Sum is too large, move right pointer to decrease the sum
52                    right--;
53                }
54            }
55        }
56        
57        return result;
58    }
59}