/* Time Complexity : O(n) 
 *   n - length of heights array */
/* Space Complexity : O(h) 
 *   h - height of the stack */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Monotonic increasing stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i < n; i ++){
            while(st.peek() != -1 && heights[i] < heights[st.peek()]){                
                int currHeight = heights[st.pop()];
                int currWidth = (i - st.peek() - 1);
                max = Math.max(max, currHeight * currWidth);
            }
            st.push(i);
        }
        while(st.peek() != -1){
            int currHeight = heights[st.pop()];
            int currWidth = (n - st.peek() - 1);
            max = Math.max(max, currHeight * currWidth);
        }
        return max;
    }
}