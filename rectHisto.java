/**
 * Time Complexity (TC):
 * The algorithm iterates through the heights array twice (from left and right).
 * Each element is pushed and popped from both stacks at most once.
 * So, the overall time complexity is O(n), where n is the length of the heights array.
 *
 * Space Complexity (SC):
 * The space used by the two stacks is proportional to the number of elements in the heights array, which is O(n).
 */

import java.util.ArrayDeque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> st1 = new ArrayDeque<>();
        ArrayDeque<Integer> st2 = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // Previous smaller element
        for (int i = 0; i < n; i++) {
            int num = heights[i];
            while (!st1.isEmpty() && heights[st1.peek()] > num)
                st1.pop();
            left[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }

        // Next greater element
        for (int i = n - 1; i >= 0; i--) {
            int num = heights[i];
            while (!st2.isEmpty() && heights[st2.peek()] >= num)
                st2.pop();
            right[i] = st2.isEmpty() ? n : st2.peek();
            st2.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}

