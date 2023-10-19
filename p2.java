// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        int max = 0;
        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            while(stk.peek() != -1 && heights[stk.peek()] > height){
                int popped = stk.pop();
                max = Math.max(max, heights[popped] * (i-stk.peek()-1));
            }
            stk.push(i);
        }

        while(stk.peek() != -1){
            int popped = stk.pop();
            max = Math.max(max, heights[popped] * (heights.length-stk.peek()-1));
        }

        return max;
    }
}