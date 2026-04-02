class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] differences = new int[gas.length];

        for(int i = 0; i < gas.length; i++) {
            differences[i] = gas[i] - cost[i];
        } 
        int sum = 0;
        for(int num: differences) {
            sum += num;
        }
        if(sum < 0) return -1;
        else {
            int tank = 0;
            int start = 0;

            for (int i = 0; i < differences.length; i++) {
            tank += differences[i];
                if (tank < 0) {
                tank = 0;
                start = i + 1; // every start up to here is eliminated
                 }
            }
                return start;

        }
    }
}
