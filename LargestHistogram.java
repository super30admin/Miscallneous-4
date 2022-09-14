import java.util.Stack;

//Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        st.push(-1);
        for(int i=0;i<heights.length;i++){
            while(st.peek()!=-1 && heights[i]<heights[st.peek()]){
               int curr=heights[st.pop()];
               max=Math.max(max,(i-st.peek()-1)*curr);

            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int ele=heights[st.pop()];
            max=Math.max(max,(heights.length-st.peek()-1)*ele);
        }
       return max; 
    }
}