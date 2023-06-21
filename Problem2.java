//Time-> O(n)
//Space -> O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0; 
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int result = 0; 
        st.push(-1);
        for(int i = 0; i < n; i++){
            if(st.peek() == - 1 || heights[i] >= heights[st.peek()]){
                st.push(i);
            }
            else{
                while(st.peek() != -1 && heights[i] < heights[st.peek()]){
                    int popped = st.pop();
                    int currArea = heights[popped] * (i - st.peek() - 1);
                    result = Math.max(result, currArea);
                }
                st.push(i);
            }
        }
        while(st.peek() != -1){
            int popped = st.pop();
            int currArea = heights[popped] * (n - st.peek() - 1);
            result = Math.max(result, currArea);
        }
        return result;
    }
}
