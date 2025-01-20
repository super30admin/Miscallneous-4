class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[i] < heights[st.peek()]){
                 int popped = st.pop();
                 result = Math.max(result, heights[popped] * (i-st.peek()-1));
            }

            st.push(i);
        }

        while(st.peek()!=-1){
            int popped = st.pop();
            result = Math.max(result, heights[popped] * (n-st.peek()-1));
        }

        return result;
    }
}