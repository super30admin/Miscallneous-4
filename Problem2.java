// TC: O(N)
// SC: O(N)
public class Problem2 {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result=0;
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[i] < heights[st.peek()]){
                int height = heights[st.pop()];
                result = Math.max(result, height * (i - st.peek() - 1));
            }
            st.push(i);
        }

        while(st.peek() != -1){
            int height = heights[st.pop()];
            result = Math.max(result, height * (n - st.peek() - 1));
        }

        return result;
    }
}
