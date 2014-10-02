package Tree;

import helperClass.TreeNode;

import java.util.ArrayList;

public class InOrderMorris {
	public void inorderMorris(TreeNode root, ArrayList<Integer> values) {
		TreeNode cur = root;

		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) { // set right to successor
					pre.right = cur;
					cur = cur.left;
				} else { // visit and revert the change
					pre.right = null;
					values.add(cur.val);
					cur = cur.right;
				}
			} else { // visit and move to successor
				values.add(cur.val);
				cur = cur.right;
			}
		}
	}
}
