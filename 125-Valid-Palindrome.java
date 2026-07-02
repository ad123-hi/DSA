class Solution {
public static boolean isPalindrome(String s) 
    {
        String p="";
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i=s.length()-1;i>=0;i--)
        {
          p=p+s.charAt(i);
        }
        return s.equals(p);
    }
}