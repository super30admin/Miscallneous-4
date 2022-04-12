// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int area = 0;

        int i = 0;
        while(i < heights.length){

            if(st.isEmpty() || heights[i] >= heights[st.peek()] ){
                st.push(i);
                i++;
            }else{
                int top = st.pop();
                if(st.isEmpty()){
                    area = heights[top] * i;
                }else{
                    area = heights[top] * (i - st.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                area = heights[top] * i;
            }else{
                area = heights[top] * (i - st.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
