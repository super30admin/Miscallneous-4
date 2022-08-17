// Time Complexity : O(2N)
// Space Complexity : O(N),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class LargestRectangleInHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if(heights == null || heights.length == 0) return 0;
            int n = heights.length;
            int maxArea = 0;
            Stack<Integer> st = new Stack<>();
            st.push(-1);
            for(int i =0; i<n; i++) {
                if(st.peek() == -1 || heights[i] >= heights[st.peek()]) {
                    st.push(i);
                } else {
                    while(st.peek() != -1 && heights[i] < heights[st.peek()]) {
                        int popped = st.pop();
                        int currArea = heights[popped] * (i - st.peek() - 1);
                        maxArea = Math.max(maxArea, currArea);
                    }
                    st.push(i);
                }
            }
            while(st.peek() != -1) {
                int popped = st.pop();
                int currArea  =heights[popped] * (n - st.peek() - 1);
                maxArea = Math.max(maxArea, currArea);
            }
            return maxArea;
        }
    }
}
