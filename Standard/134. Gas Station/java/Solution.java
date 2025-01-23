class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int starting = 0;
        int gasAvailable = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gasAvailable += gas[i] - cost[i];

            if (gasAvailable < 0) {
                gasAvailable = 0;
                starting = i + 1;
            }
        }

        return totalCost > totalGas ? -1 : starting;
    }
}