class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] netGas = new int[gas.length];

        for(int i = 0 ; i < netGas.length; i++) {
            netGas[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for(int diff: netGas) {
            sum += diff;
        }
        if(sum < 0) {
            return -1;
        } else {
            int tank =0;
            int pos =0;
            for(int i= 0; i < netGas.length; i++) {
                tank += netGas[i];
                if(tank < 0) {
                    tank = 0;
                    pos = i + 1;
                    // skip over to the right.
                }
            }
            return pos;
        }
        
    }
}
