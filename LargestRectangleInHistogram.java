public class LargestRectangleInHistogram_BruteForce {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        int n = heights.length;
        int max = heights[0];
        for(int i=0;i<n;i++){
            int min = heights[i];
            for(int j=i;j<n;j++){
                min = Math.min(min, heights[j]);
                max = Math.max(max, min*(j-i+1));
            }
        }
        return max;
    }
}

// Time Complexity - O(n2)
// Space Complexity - O(n)

public class LargestRectangleInHistogram_Optimized {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = heights.length;
        int max = 0;
        int i=0;
        for(i=0;i<n;i++){
            while(st.peek() != -1 && heights[i]<heights[st.peek()]){
                // Resolving the rectangle
                max = Math.max(max, heights[st.pop()]*(i-st.peek()-1));
            }
            st.push(i);
        }
        while(st.peek() != -1){
            max = Math.max(max, heights[st.pop()]*(i-st.peek()-1));
        }
        return max;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)