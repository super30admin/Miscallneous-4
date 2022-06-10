// Time Complexity : O(N) where N is the length of heights array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The idea is we can find max area using current height by finding the left and right limit to it
// The left and right limit means the position where the height is lesser than current.
// We can find the width by taking the difference and multiply with current height to get area
// Create a stack and keep pushing element into it until we get a smaller element
// If the element is smaller that means we got right limit of the one in stack
// Pop it to get the height and peek stack to get left limit. Calculate area and save it if better.
// Keep repeating this. Finally when we reach the end of array. All the elements in left in the stack
// Will have their right limit as length of height, We calculate areas for these too.
// Finally return the max area
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(-1);
        int i = 0;
        while(i < heights.length){   
            while(st.peek() != -1 && heights[st.peek()] > heights[i]){
                int area = heights[st.pop()] * (i-st.peek()-1);
                max = Math.max(max, area);
            }
            st.push(i);
            i++;
        } 
        while(st.peek() != -1){
            int area = heights[st.pop()] * (heights.length-st.peek()-1);
            max = Math.max(max, area);
        }
        return max;
    }
}