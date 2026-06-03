class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = (Character)s1.charAt(i);
            if (freq.containsKey(c)) {
                freq.replace(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        int start = 0; 
        int end = start + s1.length() - 1;
        Map<Character, Integer> copy = new HashMap<>();
        copy.putAll(freq);

        while (start <= s2.length() - s1.length()) {
            int idx = start;
            boolean found = true;
            copy.putAll(freq);

            while (idx <= end) {
                char c = s2.charAt(idx);
                if (copy.containsKey(c) && copy.get(c) > 0) {
                    copy.replace(c, copy.get(c) - 1);
                    idx++;
                } else {
                    found = false;
                    break;
                }
            }

            if (found) {
                return found;
            } else {
                start++;
                end++;
            }
        }

        return false;
    }
}
