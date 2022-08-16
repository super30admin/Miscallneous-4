//Time: O(N) | Space: O(N)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        st.push(-1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            while(st.peek() != -1 && heights[i] < heights[st.peek()]) {
                max = Math.max(max, heights[st.pop()] * (i-st.peek()-1));
            }
            st.push(i);
        }
        while(st.peek() != -1) {
            max = Math.max(max, heights[st.pop()] * (n-st.peek()-1));
        }
        return max;
    }
}