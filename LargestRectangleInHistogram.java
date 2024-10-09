// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = heights.length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[i] < heights[st.peek()]) {
                int popped = st.pop();
                area = Math.max(area, heights[popped] * (i - st.peek() - 1));
            }
            st.push(i);
        }

        while (st.peek() != -1) {
            int popped = st.pop();
            area = Math.max(area, heights[popped] * (n - st.peek() - 1));
        }

        return area;
    }
}