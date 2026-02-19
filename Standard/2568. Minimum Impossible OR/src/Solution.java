import java.util.HashSet;

class Solution {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> master = new HashSet<>();

        for (int num : nums) {
            if ((num & (num - 1)) == 0) {
                master.add(num);
            }
        }

        int res = 0;
        while (true) {
            int target = (int) Math.pow(2, res);
            if (!master.contains(target)) {
                return target;
            }

            res++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long t0 = System.nanoTime();
        System.out.println(s.minImpossibleOR(new int[]{8388608,131072,128,2097152,65536,2048,438,1048576,8192,32,8,64,1024,2244,512,262144,4096,16384,4,256,2,4194304,2203,16,32768,410,524288,765,1}));
        long t1 = System.nanoTime();
        System.out.printf("%d micro second%n", (t1 - t0) / 1_000);
    }
}