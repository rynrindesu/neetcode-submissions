class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) { return 0; }
        // Store character frequencies within the window
        Map<Character, Integer> freq = new HashMap<>();
        
        int maxLength = 0;  // Maximum substring of repeated character
        int maxFreq = 0;    // Used to calculate the number of replacements needed

        int wndStart = 0;   
        for (int i = 0; i < s.length(); i++) {
            Character current = (Character)s.charAt(i);
            // Update frequency of the current character 
            if (freq.containsKey(current)) {
                freq.replace(current, freq.get(current) + 1);
            } else {
                freq.put(current, 1);
            }

            int wndSize = i - wndStart + 1;
            maxFreq = Math.max(maxFreq, freq.get(current));  

            int replacementNum = (wndSize) - maxFreq; 
            // Update the maxLength if substring is still valid
            if (replacementNum <= k) {
                maxLength = Math.max(maxLength, i - wndStart + 1); 
            } else {
                // Remove an instance of the first character when updating the window
                Character start = (Character)s.charAt(wndStart);
                freq.replace(start, freq.get(start) - 1);
                wndStart++; 
            }
            
        }

        return maxLength; 
    }
}
