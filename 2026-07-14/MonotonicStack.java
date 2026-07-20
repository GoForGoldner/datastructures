class MonotonicStack {
	public int[] nextGreater(int[] nums) {
		int n = nums.length;
		
		int[] output = new int[n];
		Arrays.fill(output, -1);
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() &&
				nums[stack.peek()] < nums[i]) {
				output[stack.pop()] = nums[i];
			}
			
			stack.push(i);
		}
		
		return output;
	}
}