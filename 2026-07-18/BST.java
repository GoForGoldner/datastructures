class TreeNode {
	int val;
	TreeNode left, right;
	
	TreeNode(int val) {
		this.val = val;
	}
}

class BST {
	TreeNode root;
		
	public void insert(int val) {
		insertHelper(root, val);
	}
	
	private TreeNode insertHelper(TreeNode node, int val) {
		if (node == null) return new TreeNode(val);
		
		if (val < node.val) {
			node.left = insertHelper(node.left, val);
		}
		
		if (val > node.val) {
			node.right = insertHelper(node.right, val);
		}
		
		return node;
	}
	
	public void remove(int val) {
		removeHelper(root, val);
	}
	
	private TreeNode removeHelper(TreeNode node, int val) {
		if (node == null) return;
		
		if (val < node.val) {
			node.left = removeHelper(node.left, val);
		} else if (val > node.val) {
			node.right = removeHelper(node.right, val);
		} else {
			if (node.left == null) return node.right;
			else if (node.right == null) return node.left;
			else {
				// Remove the leftest of the right nodes? 
				TreeNode s = node.right;
				while (s.left != null) s = s.left;
				node.val = s.val;
				node.right = removeHelper(node.right, val);
			}
		}
	}
	
	public List<Integer> toList() {
		List<Integer> out = new ArrayList<>();
		
		return toListHelper(node, out);
	}
	
	private void toListHelper(TreeNode node, List<Integer> out) {
		if (node == null) return;
		
		toListHelper(node.left, out);
		out.add(node.val);
		toListHelper(node.right, out);
	}
}