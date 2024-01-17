/* Time Complexity : O(n^2) 
 *   n - length of heights array */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int currHeight = heights[i];
            int l = i;
            while(l >= 0 && heights[l] >= currHeight){
                l--;
            }
            int r = i;
            while(r < n && heights[r] >= currHeight){
                r++;
            }
            int currWidth = r - l - 1;
            max = Math.max(max, currHeight*currWidth);
        }
        return max;
    }
}