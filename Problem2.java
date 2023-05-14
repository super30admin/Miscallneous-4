import java.util.Stack;

/*
Largest Rectangle in histogram
approach: use monotonic increasing stack, whenever we want to keep track of increasing or decreasing sequence of numbers
time: O(2n)
space: O(n)
 */
public class Problem2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        int i = 0;
        for (i=0;i< heights.length;i++) {

            while (stack.peek()!= -1 && stack.peek() > heights[i]) {
                int popped = stack.pop();
                maxArea = Math.max(maxArea, heights[popped]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!= -1) {
            int popped = stack.pop();
            maxArea = Math.max(maxArea, heights[popped]*(i-stack.peek()-1));
        }
        return maxArea;
    }
}
