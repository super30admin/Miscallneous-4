// Approach: Using stack, calculate the maxArea possible.
// Note: Store values greater than current onto the stack. If lower height encountered, keep popping from stack calculating their Area and storing max so far.
// currWidth = i - stack.peek() - 1
// Note: Store only the indexes on stack as the heights can be retreived by the heights[] array.
// Note: After all the iterations. Run a while loop until the stack becomes empty i.e. till != -1 to calculate remaining Areas.
// -------||-------
// Time: O(n) as n numbers are pushed and popped.
// Space: O(n) for stack

import java.util.*;

class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);                                         // IMP: to mark as the start of the stack
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i<n; ++i) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {                            // for the remaining elements left in the stack
            int currHeight = heights[stack.pop()];
            int currWidth = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        System.gc();            // Garbage collector to free up space used.
        return maxArea;
    }
}