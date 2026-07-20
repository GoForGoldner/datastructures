public class MonotonicStack {
	public int[] greaterElements(int[] nums) {
		int n = nums.length;
		
		int output = new int[n];
		Arrays.fill(output, -1);
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				output[stack.poll()] = num;
			}
			
			stack.offerFirst(i);
		}
		
		return output;
	}
}