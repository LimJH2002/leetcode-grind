class Solution {
    public String reverseWords(String s) {
        String str = s.strip();
        String[] arr = str.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i > 0; i--) {
            res.append(arr[i]);
            res.append(" ");
        }

        res.append(arr[0]);

        return res.toString();
    }
}