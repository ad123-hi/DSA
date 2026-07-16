import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
    
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 != 0) {
                
                arr.add(nums[i] / 10);
                arr.add(nums[i] % 10);
            } else {
                
                arr.add(nums[i]);
            }
        }
        
        
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        
        return result;
    }
}
