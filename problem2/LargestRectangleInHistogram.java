// Time Complexity : O(n), n -> Number of histogram bars
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		int maxArea = 0;
		int n = heights.length;

		for (int i = 0; i < n; i++) {
			while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
				maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
			}
			stack.push(i);
		}

		while (stack.peek() != -1) {
			maxArea = Math.max(maxArea, heights[stack.pop()] * (n - stack.peek() - 1));
		}

		return maxArea;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] heights = { 2, 1, 5, 6, 2, 3 };

		System.out.println("Area of Largest Rectangle in histogram = " + obj.largestRectangleArea(heights));
	}

}
