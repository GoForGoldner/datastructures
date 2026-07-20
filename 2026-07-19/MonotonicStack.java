public class MonotonicStack {
  blic int[] findGreater(int[] nums) {
    n = nums.length;
    ] output = new int[n];
    ys.fill(output, -1);

    e<Integer> stack = new ArrayDeque<>();

    (int i = 0; i < n; i++) {
      e (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        index = stack.poll();
        ut[index] = nums[i];
      

      k.add(i);
    

    rn output;
  
}
