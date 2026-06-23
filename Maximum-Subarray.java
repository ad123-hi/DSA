1import java.util.Arrays;
2
3class Solution {
4    public int maxSubArray(int[] nums) {
5        int max = Integer.MIN_VALUE;
6        int sum = 0;
7        
8        int start_index = 0;
9        int start = 0;
10        int end_index = 0;
11        
12        for (int i = 0; i < nums.length; i++) {
13            
14            if (sum == 0) {
15                start = i;
16            }
17            
18            sum += nums[i];
19            
20            if (sum > max) {
21                max = sum;
22                start_index = start;
23                end_index = i;
24            }
25            
26            if (sum < 0) {
27                sum = 0;
28            }
29        }
30        
31        int[] result = new int[end_index - start_index + 1];
32        for (int i = start_index, j = 0; i <= end_index; i++, j++) {
33            result[j] = nums[i];
34        }
35        
36        System.out.println(Arrays.toString(result));
37        
38        return max;
39    }
40}