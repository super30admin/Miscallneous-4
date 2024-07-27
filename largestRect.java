
// Using Monotonic Stack
import java.util.*;

// Tc: O(n) Sc: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {

            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index);
                index++;
            } else {

                int topOfStack = stack.pop();

                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);

                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
}

/*
 * // Using left and right arrays
 * 
 * class Solution {
 * public int largestRectangleArea(int[] heights) {
 * // Tc: O(n) Sc: O(n)
 * if (heights.length == 0 || heights == null)
 * return 0;
 * 
 * int n = heights.length;
 * 
 * int left[] = new int[n];
 * int right[] = new int[n];
 * 
 * left[0] = -1;
 * right[n - 1] = n;
 * 
 * for (int i = 1; i < n; i++) {
 * int prev = i - 1;
 * while (prev >= 0 && heights[prev] >= heights[i]) {
 * prev = left[prev];
 * }
 * left[i] = prev;
 * }
 * 
 * for (int i = n - 2; i >= 0; i--) {
 * int prev = i + 1;
 * while (prev < n && heights[prev] >= heights[i]) {
 * prev = right[prev];
 * }
 * right[i] = prev;
 * }
 * 
 * int ans = 0;
 * for (int i = 0; i < n; i++) {
 * ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
 * }
 * 
 * return ans;
 * }
 * }
 * 
 */

// TLE Solution:
/*
 * class Solution {
 * public int largestRectangleArea(int[] heights) {
 * // Tc: O(n^2) Sc: O(1)
 * int max = 0;
 * for (int i = 0; i < heights.length; i++) {
 * int min = heights[i];
 * for (int j = i; j < heights.length; j++) {
 * min = Math.min(min, heights[j]);
 * max = Math.max(max, min * (j - i + 1));
 * }
 * }
 * return max;
 * }
 * }
 */