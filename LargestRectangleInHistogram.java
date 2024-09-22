import java.util.ArrayDeque;
import java.util.Deque;

// LC 84
public class LargestRectangleInHistogram {

    /**
     * TLE
     * <p>
     * For each height, find the lowest height than the current height to the left and right.
     * <p>
     * TC: O(n^2)
     * SC: O(1)
     */
    public int largestRectangleArea_brute(int[] heights) {
        int max = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && heights[left] >= curr) {
                left--;
            }
            while (right < n && heights[right] >= curr) {
                right++;
            }
            int length = right - left - 1;
            int area = length * curr;
            max = Math.max(max, area);
        }
        return max;
    }

    /**
     * For each index, maintain the next small on left and right.
     * then, r - l - 1 == length
     * <p>
     * TC: O(4n)
     * SC: O(2n); 1N for the 1D left small array
     * and the other 1N for the worst case scenario in which the stack becomes full of n elements i.e. input is in ascending order.
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_better(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] leftSmall = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        /*
         * Time: O(2n)
         */
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // before pushing, top marks the left boundary
            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        /*
         * Time: O(2n)
         */
        for (int i = n - 1, rightSmall = n; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // before popping, incoming marks the right boundary
            rightSmall = stack.isEmpty() ? n : stack.peek();
            int length = rightSmall - leftSmall[i] - 1;
            int area = heights[i] * length;
            max = Math.max(max, area);
            stack.push(i);
        }
        return max;
    }

    /**
     * TC: O(2n); 1 for traversing the entire array and the other in the worst case scenario in which the stack becomes full of n elements
     * i.e. input is in ascending order.
     * SC: O(n); to maintain the stack and in the worst case scenario in which the stack becomes full of n elements
     * i.e. input is in ascending order.
     * @param heights
     * @return
     */
    public int largestRectangleArea_optimal(int[] heights) {
        int max = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        /*
         *  NOTE: left small for each element is the one maintained below in the stack
         * and right small is the one which replaces it while maintaining the left small stack.
         * hence, no need of 2 stacks.
         */
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // before pushing, top marks the left boundary
                int height = heights[stack.pop()];
                int leftSmall = stack.isEmpty() ? -1 : stack.peek();
                int rightSmall = i;
                int length = rightSmall - leftSmall - 1;
                int area = height * length;
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int leftSmall = stack.isEmpty() ? -1 : stack.peek();
            int rightSmall = n;
            int length = rightSmall - leftSmall - 1;
            int area = height * length;
            max = Math.max(max, area);
        }
        return max;
    }

    /**
     * just optimising to avoid code redundancy by running the loop till n.
     * @param heights
     * @return
     */
    public int largestRectangleArea_optimal2(int[] heights) {
        int max = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                // before pushing, top marks the left boundary
                int height = heights[stack.pop()];
                int leftSmall = stack.isEmpty() ? -1 : stack.peek();
                int rightSmall = i;
                int length = rightSmall - leftSmall - 1;
                int area = height * length;
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
