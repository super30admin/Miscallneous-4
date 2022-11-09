// Time Complexity : O(2*n) where n = length of heights array
// Space Complexity : O(n) where n = length of heights array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//84. Largest Rectangle in Histogram (Hard) - https://leetcode.com/problems/largest-rectangle-in-histogram/
// Time Complexity : O(2*n) where n = length of heights array
// Space Complexity : O(n) where n = length of heights array
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for (int i = 0; i < heights.length; i++) { // O(2*n)
            int height = heights[i];
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int currArea = heights[stack.pop()] * (i - stack.peek() - 1);
                max = Math.max(max, currArea);
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int index = stack.pop();
            int currArea = heights[index] * (heights.length - stack.peek() - 1);
            max = Math.max(max, currArea);
        }
        
        return max;
    }
}