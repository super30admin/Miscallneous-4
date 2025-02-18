// Approach : BruteForce Approach - Try every possible pair of bars and find the area formed between
// them using the min height of shortest bar and space between them as wdith of rectangle
// Time : O(n^2);
// Space : 
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                minHeight = Math.min(minHeight , heights[j]);
                maxArea = Math.max(maxArea , minHeight* (j-i+1));
            }
        }
        return maxArea;
    }
}

// Approach : 
// First Observation : when we move from bigger height to lower height we cannot resolve the bigger height because lower height can extend and form the max area of rectangle. So put the bigger height in the stack.
// Second Observation : When we come across lower height then we can extend the smaller height to form the max area rectangle.So process the bigger height so far available in the stack and calculate the area.
// so wherever we couldn't resolve then we have them in stack and come back to it later.
// Time : O(n) + O(n);
// Space : O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1); // By default push the index of height to compare the first height
        int n= heights.length;
        int result =0;

        for(int i=0;i<n;i++){

            while(stk.peek()!=-1 && heights[i]<heights[stk.peek()]){
                // we cannot extend the bigger height rectangle stored in stack .
                // So we can identify the area formed by the bigger height rectangle so far
                int popped = stk.pop();
                result = Math.max(result, heights[popped]* (i-stk.peek()-1));

            }
            // you are on a bigger or equal height than what is already available in stack.So we cannot resolve hence save them in stack.
            stk.push(i);
        }

        // If the stack is not empty implies it might also be possible that left over elements in stack can form max rectangle
        // we need to stop until the left most boundary.
        while(stk.peek()!=-1){
            int popped = stk.pop();
            // Area = popped height * (incoming boundary - top of the stack/ left boundary - 1)
            result = Math.max(result,heights[popped]* (n-stk.peek()-1) );
        }

        return result;
    }
}