// Time Complexity : O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take a stack to store the index whose value is higher: then the current index; if not then pop till the value in the top of the stack is less then currnet value; and find the area with the index - st.peek()-1
// Your code here along with comments explaining your approach
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = Integer.MIN_VALUE;
        int i = 0;
        while( i < heights.length){
            if( st.peek() == -1 || heights[i] > heights[st.peek()]){
                st.push(i);
            }else{
                while( st.peek() != -1 && heights[i] < heights[st.peek()]){
                    int idx = st.pop();
                    area = Math.max(area, heights[idx]*(i-st.peek()-1));
                }
                st.push(i);
            }
            i++;
        }
        while(st.peek() != -1){
            int idx = st.pop();
            area = Math.max(area, heights[idx]*(i-st.peek()-1));
        }
        return area;
    }
}
// brout-force
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int area = heights[0];
//         for(int i = 0; i < heights.length; i++){
//             int min = heights[i];
//             for(int j = i; j < heights.length; j++){
//                 min = Math.min(min, heights[j]);
//                 area = Math.max(area, min*(j-i+1));
//                 //System.out.println(min+" "+area+" "+i+" "+j);
//             }

//         }
//         return area;
//     }
// }
