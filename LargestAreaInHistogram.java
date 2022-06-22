//Time Complexity O(N)
//Space ComplexityO(N)
//LeetCode tested

import java.util.Stack;

public class LargestAreaInHistogram {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = i==n?0: h[i];
            while (!s.isEmpty() && currentHeight < h[s.peek()]){
                int top = s.pop();
                int width= s.isEmpty()?i:i - s.peek() - 1;
                int area = width * h[top];
                maxArea = Math.max(maxArea,area);
            }
            s.push(i);
        }
        return maxArea;
    }
}
