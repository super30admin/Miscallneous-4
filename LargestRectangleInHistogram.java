//Using Monotonic Stack
//TC : O(2N)
//SC : O(N)
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int popped = stack.pop();
                int currArea = heights[popped] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }
        // resolve the pending elementds in Stack
        while (stack.peek() != -1) {
            int popped = stack.pop();
            int currArea = heights[popped] * (n - stack.peek() - 1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}