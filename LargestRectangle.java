import java.util.Stack;

// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int maxArea = 0;
        for(int i=0; i<heights.length; i++)
        {
            while(st.peek()!= -1 && heights[i] < heights[st.peek()]){
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }

        while(st.peek()!= -1){
            int height = heights[st.pop()];
            int width = heights.length - st.peek() - 1;
            maxArea = Math.max(maxArea, height*width);
        }

        return maxArea;
    }
}
