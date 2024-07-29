//Time Complexity : O(2n)
//Space Complexity : O(n)
//Did this code run successfully on leetcode: Yes
//Any problem faced during coding this : No
class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = 0;
        for(int i = 0; i < n; i++) {
            while(st.peek() != -1 && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                area = Math.max(area, height*(i-st.peek()-1));
            }
            st.push(i);
        }
        while(st.peek() != -1) {
            int height = heights[st.pop()];
            area = Math.max(area, height*(n-st.peek()-1));
        }
        return area;
    }
}