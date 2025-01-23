class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean sudden = false;

        if (strs.length == 1 || strs[0].isEmpty()) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            index = i;
            char current = strs[0].charAt(i);

            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != current) {
                    sudden = true;
                    break;
                }
            }

            if (sudden) {
                return strs[0].substring(0, index);
            }
        }

        return strs[0].substring(0, index + 1);
    }
}