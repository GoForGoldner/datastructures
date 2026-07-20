import java.util.ArrayList;

public class BinarySearchTreeTwo {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  TreeNode root;

  public void insert(int val) {
    root = insertHelper(root, val);
  }

      
  private TreeNode insertHelper(TreeNode node, int val) {
    if (node == null) r
      turn new TreeNode(val);

      
    if (val < node.val) node.left = insertHelper(node.left, val);
    else node.right = insertHelper(node.right, val);

    return node;
  }

  public void remove(int val) {
    root = removeHelper(root, val);
  }

      
  private TreeNode removeHelper(TreeNode node, int val) {
    if (node == null) r
      turn null;

      
    if (val < node.val) node.left = removeHelper(node.left, val);
    else if (val > node.val)
        node.right = removeHelper(node.right, val);
    else {
        
      if (node.left == null) return node.right;
      else if (node.right == null) return node.left;
      else {
          
        TreeNode s = node.right;
        while (s.left != null) s = s.left;
        node.val = s.val;
        node.right = removeHelper(node.right, node.val);
      }
    }

    return node;
  }

  public List<Integer> toList() {
    List<Integer> output = new ArrayList<>();
    toListHelper(root, output);
    return output;
  }

      
  private void toListHelper(TreeNode node, List<Integer> output) {
    if (node == null) return;

    toListHelper(node.left, output);
    output.add(node.val);
    toListHelper(node.right, output);
  }
}
