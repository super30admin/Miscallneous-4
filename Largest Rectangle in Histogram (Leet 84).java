/*
Efficient using monotonic stack
Time: O(n)
Space: O(n)
Executed Successfully: Yes
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if(st.peek() == -1 || heights[i] >=  heights[st.peek()]){
                st.push(i);
            }else{
                while (st.peek() != -1 && heights[i] < heights[st.peek()]){
                    int popped = st.pop();
                    int curr = heights[popped] * (i - st.peek() - 1);
                    res = Math.max(res, curr);     
                }
                st.push(i);
            }
        }
        
        while (st.peek() != -1){
            int popped = st.pop();
            int curr = heights[popped] * (n - st.peek() - 1);
            res = Math.max(res, curr);
        }
        return res;
        
    }
}
