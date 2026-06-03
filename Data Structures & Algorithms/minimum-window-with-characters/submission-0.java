class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        // For characters in t, store its respective frequencies
        int[] freq_t = new int[58]; 
        for (int i = 0; i < t.length(); i++) {
            freq_t[t.charAt(i) - 'A']++;
        }    

        int[] freq_s = new int[58];     

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int startIdx = -1;
        int count = 0;  // Track the number of characters found successfully

        for (int j = 0; j < s.length(); j++) {
            int currChar = s.charAt(j) - 'A';
            freq_s[currChar]++;

            // Increment the number of found characters
            if (freq_t[currChar] > 0 && freq_s[currChar] <= freq_t[currChar]) {
                count++;
            }

            // Range [start, j] contains all target characters 
            if (count == t.length()) {
                int startChar;
                while (freq_s[startChar = s.charAt(start) - 'A'] > freq_t[startChar] || freq_t[startChar] == 0) {
                    // For repeated target characters, exclude it from the window
                    if (freq_s[startChar] > freq_t[startChar]) {
                        freq_s[startChar]--;
                    }
                    start++;
                }
            
                int len = j - start + 1;
                if (len < minLength) {
                    startIdx = start;
                    minLength = len;
                }
            } 

        }

        if (startIdx == -1) {
            return "";
        }

        return s.substring(startIdx, startIdx + minLength);
    }
}
