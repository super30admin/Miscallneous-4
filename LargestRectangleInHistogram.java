//TC : O(N)
//SC :O(N)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int area = 0;
        int i = 0;
        for(i = 0; i< heights.length; i++){
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                int top = stack.pop();
                area = Math.max(area, heights[top] * (i - stack.peek() - 1) );   
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int top = stack.pop();
            area = Math.max(area, heights[top] * (i - stack.peek() - 1) );   
        }
        return area;
    }

}
