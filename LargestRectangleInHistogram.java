// Time Complexity : O(2*n) where n = length of heights array
// Space Complexity : O(n) where n = length of heights array

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) { // O(2*n)
            int height = heights[i];
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int currArea = heights[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, currArea);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int index = stack.pop();
            int currArea = heights[index] * (heights.length - stack.peek() - 1);
            max = Math.max(max, currArea);
        }

        return max;
    }
}

// ----------------------------------------------------------------------------------------------------------------
// Brute Force approach
// TC - O(n^2)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (heights == null || n == 0) return 0;
        int max = heights[0];
        for (int i = 0; i < n; i++) {
            int min = heights[1];
            for (int j = i; j < n; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (j - i + 1));
            }
        }
        return max;
    }
}