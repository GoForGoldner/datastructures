public class CarFleet {
  class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      int n = position.length;
      int[][] cars = new int[n][];

      for (int i = 0; i < n; i++) {
        cars[i] = new int[] { position[i], speed[i] };
      }

      Arrays.sort(cars, (a, b) -> b[0] - a[0]);

      int count = 0;
      double prevTime = 0;

      for (int[] car : cars) {
        int p = car[0], s = car[1];
        double time = (double) (target - p) / s;

        if (time > prevTime) {
          count++;
          prevTime = time;
        }
      }

      return count;
    }
  }
}
