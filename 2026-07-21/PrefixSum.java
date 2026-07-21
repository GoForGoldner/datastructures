public class PrefixSum {
  public int[] buildPrefix(int[] nums) {
    int n = nums.length;

    int[] prefix = new int[n + 1];
    prefix[0] = 0;

    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }

    return prefix;
  }

  public int rangeQuery(int[] prefix, int left, int right) {
    return prefix[right + 1] - prefix[left];
  }
}
