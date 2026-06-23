1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
5        Set<Integer> set1 = new HashSet<>();
6        Set<Integer> set2 = new HashSet<>();
7        
8        for (int num : nums1) {
9            set1.add(num);
10        }
11        for (int num : nums2) {
12            set2.add(num);
13        }
14        
15        List<Integer> ans1 = new ArrayList<>();
16        for (int num : set1) {
17            if (!set2.contains(num)) {
18                ans1.add(num);
19            }
20        }
21        
22        List<Integer> ans2 = new ArrayList<>();
23        for (int num : set2) {
24            if (!set1.contains(num)) {
25                ans2.add(num);
26            }
27        }
28        
29        List<List<Integer>> result = new ArrayList<>();
30        result.add(ans1);
31        result.add(ans2);
32        
33        return result;
34    }
35}