import java.util.*;

class Solution {
    // List to store the maximum values at each level of the binary tree
    List<Integer> result;

    // Depth-first search (DFS) function to traverse the tree and find maximum values at each level
    private void dfs(TreeNode root, int level) {
        // Base case: if the node is null, return
        if (root == null) return;

        // If this is the first node at this level, add its value to the result list
        if (result.size() == level) {
            result.add(root.val);
        } else {
            // Otherwise, update the existing maximum value at this level if necessary
            int currentVal = result.get(level);
            currentVal = Math.max(currentVal, root.val);
            result.set(level, currentVal);
        }

        // Recursively call DFS for left and right children at the next level
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    // Main function to initiate DFS and return the list of maximum values
    public List<Integer> largestValues(TreeNode root) {
        // Initialize the result list
        this.result = new ArrayList<>();
        // Start DFS traversal from the root node at level 0
        dfs(root, 0);
        // Return the list of maximum values found
        return result;
    }
}
