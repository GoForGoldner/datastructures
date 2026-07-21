public class BinarySearchTree {
  class Node {
    int val;
    Node left, right;

    Node(int val) {
      this.val = val;
    }
  }

  private Node root;

  public void insert(int val) {
    root = insertHelper(root, val);
  }

  private Node insertHelper(Node node, int val) {
    if (node == null)
      return new Node(val);

    if (val < node.val)
      node.left = insertHelper(node.left, val);
    else
      node.right = insertHelper(node.right, val);

    return node;
  }

  public void remove(int val) {
    root = removeHelper(root, val);
  }

  public Node removeHelper(Node node, int val) {
    if (node == null)
      return null;

    if (val < node.val)
      node.left = removeHelper(node.left, val);
    else if (val > node.val)
      node.right = removeHelper(node.right, val);
    else {
      if (node.left == null)
        return node.right;
      if (node.right == null)
        return node.left;

      Node c = node.right;
      while (c.left != null)
        c = c.left;
      node.val = c.val;
      node.right = removeHelper(node.right, node.val);
    }

    return node;
  }

  public List<Integer> toList() {
    List<Integer> output = new ArrayList<>();
    toListHelper(root, output);
    return output;
  }

  private void toListHelper(Node node, List<Integer> output) {
    if (node == null)
      return;

    toListHelper(node.left, output);
    output.add(node.val);
    toListHelper(node.right, output);
  }
}
