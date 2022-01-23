// Time Complexity: O(2n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int i = 0;
        while(i < heights.length) {
            // should i resolve or not
            if(st.peek() == -1 || heights[i] > heights[st.peek()]) {
                st.push(i);
            } else {
                // resolve
                while(st.peek() != -1 && heights[st.peek()] > heights[i]) {
                    int top = st.pop();
                    max = Math.max(max, heights[top] * (i - st.peek() - 1));
                }
                st.push(i);
            }
            i++;
        }
        while(st.peek() != -1) {
            // monotonic inccreasing order
            int top = st.pop();
            max = Math.max(max, heights[top] * (i - st.peek() - 1));
        }
        return max;
    }
}