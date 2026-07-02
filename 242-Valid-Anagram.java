import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){
            return false;
        }
  
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2); 
    }
}