// logic -
// montonically increasingly stack used. 
// so when a lower height is encountered, the previous heights are removed 
//till there are other heights which are lower or equal to this height in the stack

// time complexity = O(n)
// space complexity = O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // left most boundary
        for(int i=0;i< n ;i++) {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int popped = stack.pop();
                int currArea = heights[popped] * (i-stack.peek()-1); // -1 is added for the fact that the histogram width is 1.
                max = Math.max(max, currArea);
            }
            stack.push(i);
        }
        // end of the stack.
        while(stack.peek() !=-1) {
            int currArea = heights[stack.pop()] * (n-stack.peek()-1);
            max = Math.max(max, currArea);
        }
        
        return max;
    }
}