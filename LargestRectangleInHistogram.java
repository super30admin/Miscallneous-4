// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a monotonous increasing stack to store the increasing values, when the value drops we evaluate the stack elements till we get a smaller value in the stack
// In the stack we will store the index of the elements that are in an increasing order
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        if (heights == null || heights.length == 0) return max;

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int i=0;
        while (i < heights.length) {
            // The first element and the increasing element should go into the stack
            if (st.peek() == -1 || heights[i] >= heights[st.peek()]) {
                // monotonously increaing stack
                st.push(i);
                i++;
            }
            else {      // if there is a drop in value we evaluate the previous values
                max = Math.max(max, heights[st.pop()] * (i- st.peek() - 1));
            }
        }

        while (st.peek() != -1) {
            max = Math.max(max, heights[st.pop()] * (i- st.peek() - 1));
        }

        return max;
    }
}