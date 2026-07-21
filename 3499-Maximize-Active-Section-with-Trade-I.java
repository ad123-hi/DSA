class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        int maxDelta = 0;

        // Count total ones
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // Augment string
        String t = "1" + s + "1";
        int i = 0;
        while (i < t.length()) {
            if (t.charAt(i) == '1') {
                int j = i;
                while (j < t.length() && t.charAt(j) == '1') j++;
                // Found a block of 1s
                if (i > 0 && j < t.length() && t.charAt(i-1) == '0' && t.charAt(j) == '0') {
                    // Count left zeros
                    int l = i-1;
                    while (l >= 0 && t.charAt(l) == '0') l--;
                    int leftZeros = i-1-l;

                    // Count right zeros
                    int r = j;
                    while (r < t.length() && t.charAt(r) == '0') r++;
                    int rightZeros = r-j;

                    maxDelta = Math.max(maxDelta, leftZeros + rightZeros);
                }
                i = j;
            } else {
                i++;
            }
        }

        return totalOnes + maxDelta;
    }
}
