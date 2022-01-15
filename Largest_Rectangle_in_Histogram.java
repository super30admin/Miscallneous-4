class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        
        int max = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        for(int i = 0; i<heights.length; i++){
            while(st.peek() != -1 && heights[i] < heights[st.peek()]){
                int top = st.pop();
                max = Math.max(max, heights[top] * (i - st.peek() -1));
            }
            st.push(i);
        }
        while(st.peek() != -1){
            int top = st.pop();
            max = Math.max(max, heights[top] * (heights.length - st.peek() - 1));
        }
        return max;
            
    }
}

//TC: O(2n)
//SC: O(n)
