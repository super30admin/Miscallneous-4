// Time Complexity : O(log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach - using monotonic increasing stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st =new Stack<>();
        st.push(-1);
        int result=0;

        for(int i=0;i< n;i++){

            while(st.peek() != -1 && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                result = Math.max(result, height * (i- st.peek() -1));
            }

            st.push(i);
        }

        while(st.peek() != -1){
            int height = heights[st.pop()];
            result = Math.max(result, height * ( n-st.peek()-1));
        }

        return result;
    }
}

// O(N^2) - brute force approach
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;

        int result=0;

        for(int i=0;i<n;i++){
            int min=heights[i];

            for(int j=i;j<n;j++){
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (j-i+1));
            }
        }

        return result;
    }
}