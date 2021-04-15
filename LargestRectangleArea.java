// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0){
            return 0;
        }

        int res = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int i=0;

        while(i<heights.length){
            // keep adding the increasing heights
            if(s.peek() == -1 || heights[i] >= heights[s.peek()]){
                s.push(i);
                i++;
            }
            //resolve when the height drops
            else{
                int top = heights[s.pop()];
                res = Math.max(res,top*(i-s.peek()-1));
            }
        }

        //resolve the remaining elements in the stack
        while(s.peek() != -1){
            int top = heights[s.pop()];
            res = Math.max(res, top*(i-s.peek()-1));
        }
        return res;
    }
}