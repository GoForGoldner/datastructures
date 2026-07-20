class MonotonicStack {
	public int[] findGreater(int[] nums) {
		int n = nums.length;
		
		int[] output = new int[n];
		Arrays.fill(output, -1);
		
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				int index = stack.pollFirst();
				// Set output to new value
				output[index] = nums[i];
			}
			
			stack.offerFirst(i);
		}
		
		return output;
	}
}