public class TwoHeaps {

  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;

  public TwoHeaps() {
    left = new PriorityQueue<>((a, b) -> b - a);
    right = new PriorityQueue<>();
  }

  public void addNum(int num) {
    // Add the number to the left
    left.offer(num);

    // Move the largest element to the right
    right.offer(left.poll());

    // Fix sizing
    if (right.size() > left.size() + 1) {
      left.offer(right.poll());
    }
  }

  public int getMedian() {
    return right.size() == left.size() ? (right.peek() + left.peek()) / 2 : right.peek();
  }
}
