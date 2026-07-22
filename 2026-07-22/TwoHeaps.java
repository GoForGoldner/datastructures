public class TwoHeaps {
  private PriorityQueue<Integer> left;
  private PriorityQueue<Integer> right;

  public TwoHeaps() {
    left = new PriorityQueue<>((a, b) -> b - a);
    right = new PriorityQueue<>();
  }

  public void addNum(int num) {
    left.offer(num);

    right.offer(left.poll());

    if (right.size() > left.size() + 1) {
      left.offer(right.poll());
    }
  }

  public double getMedian() {
    return right.size() == left.size() ? (right.peek() + left.peek()) / 2 : right.peek();
  }
}
