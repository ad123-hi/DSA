1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        // Pointers for the end of valid elements in both arrays
4        int i = m - 1; // Last valid element in nums1
5        int j = n - 1; // Last element in nums2
6        int k = m + n - 1; // Last position of the entire nums1 array
7
8        // Merge from right to left (backwards)
9        while (i >= 0 && j >= 0) {
10            if (nums1[i] > nums2[j]) {
11                nums1[k] = nums1[i];
12                i--;
13            } else {
14                nums1[k] = nums2[j];
15                j--;
16            }
17            k--;
18        }
19
20        // If there are remaining elements in nums2, copy them over.
21        // (Note: If there are elements left in nums1, they are already in the correct place)
22        while (j >= 0) {
23            nums1[k] = nums2[j];
24            j--;
25            k--;
26        }
27    }
28}