import java.util.Arrays;

class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1 || s.length() == 1) {
                return s;
            }

            char[][] array = new char[numRows][(s.length() + 1) / 2];
            int x = 0;
            int y = 0;
            int mode = 0;

            for (int i = 0; i < s.length(); i++) {
                if (mode == 0) { // vertical
                    array[x++][y] = s.charAt(i);

                    if (x % (numRows - 1) == 0) {
                        mode = 1;
                    }
                } else { // zig zag across
                    array[x--][y++] = s.charAt(i);

                    if (y % (numRows - 1) == 0) {
                        mode = 0;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < (s.length() + 1) / 2; j++) {
                    if (array[i][j] != '\u0000') {
                        sb.append(array[i][j]);
                    }
                }
            }

            return sb.toString();
        }
    }