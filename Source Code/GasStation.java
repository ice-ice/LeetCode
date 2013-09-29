public int canCompleteCircuit(int[] gas, int[] cost) {
	// Note: The Solution object is instantiated only once and is reused by each test case.

	int cycle = gas.length, sum = 0, total = 0, start = 0;
	for (int i = 0; i < cycle; i++) {
	    sum += gas[i] - cost[i];
	    total += gas[i] - cost[i];
	    
	    if (sum < 0) {
	        start = i + 1;
	        sum = 0;
	    }
	}
	
	return total >= 0 ? start : -1;
}
