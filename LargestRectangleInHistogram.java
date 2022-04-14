package misc4;

import java.util.Stack;

public class LargestRectangleInHistogram {
	//Time Complexity : O(n), where n is length of heights array
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int largestRectangleArea(int[] heights) {
        // null
        if(heights == null || heights.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        
        for(int i=0; i<heights.length; i++) {
            if(stack.peek() != -1 && heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int idx = stack.peek();
                    max = Math.max(max, height * (i - idx - 1));
                }
                stack.push(i);
            }
        }
        
        while(stack.peek() != -1) {
            int height = heights[stack.pop()];
            int idx = stack.peek();
            max = Math.max(max, height * (heights.length - idx - 1));
        }
        
        return max;
    }
	
	//Time Complexity : O(n^2), where n is length of heights array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public int largestRectangleArea1(int[] heights) {
        // null
        if(heights == null || heights.length == 0)
            return 0;
        
        int max = 0;
        for(int i=0; i<heights.length; i++) {
            int min = heights[i];
            for(int j=i; j<heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (j - i + 1));
            }
        }
        
        return max;
    }
}
