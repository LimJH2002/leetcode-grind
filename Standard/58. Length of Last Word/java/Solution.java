class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int index = arr.length - 1;

        while (index > 0 && arr[index].equals(" ")) {
            index--;
        }

        return arr[index].length();
    }
}