import java.util.Stack;

public class LargestRectangle {

    // Monotonic stack - we'll only put increasing heights onto the stack
    // TC : O(n)
    // SC : O(n) - worst case, we'll be putting all the heights are in increasing order. So, need to put all of them onto the stack
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        int i=0;

        while(i < heights.length) {
            if(stack.peek() == -1 || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
        }

        while(stack.size() > 1){
            max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
        }

        return max;
    }
}
