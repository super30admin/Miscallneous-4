//Using Monotonic stack
//TC:O(2N)
//SC:O(N)
//Did it run successfully on Leetcode?:Yes
class Solution {
    public int largestRectangleArea(int[] heights) {
        if ( heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack();
        int length = heights.length;
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
                int currentHeight = heights[stack.pop()];
                int currentWidth = length - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
        return maxArea;
    }
}
