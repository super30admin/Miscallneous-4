// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0, i = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        
        while(i < heights.length) {
            if(s.peek() == -1 || heights[i] > heights[s.peek()]) {
                s.push(i);
                i++;
            }
            else
            {
                int top = s.pop();
                maxArea = Math.max(maxArea, heights[top] * (i - s.peek() - 1));
            }
        }
        while(s.peek() != -1) {
            int top = s.pop();
            maxArea = Math.max(maxArea, heights[top] * (i - s.peek() - 1));
            
        }
        
        return maxArea;
    }
}