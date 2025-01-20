import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i > 0; i--) {
            if (!arr[i].equals("")) {
                res.append(arr[i]);
                res.append(" ");
            }
        }

        res.append(arr[0]);

        return res.toString();
    }
}