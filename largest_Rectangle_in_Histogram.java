// Time Complexity : O(n) : Traverse through each height to compute the max possible area for that particular height
// Stack Complexity : O(n) ->  worst case : ascending order of the heights 

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int max = -1;
        
        // keep track of the elements to find the max range possible for a particular height
        Stack<Integer> stack = new Stack<Integer>();
        
        // Index of the element when inserted
        stack.push(-1);
        
        // Iterate through each height variable
        for( int i = 0; i < heights.length; i++){
            
            if ( stack.peek() == -1 || heights[stack.peek()] < heights[i] ) {
                
                // if incoming element is greater then push it to stack 
                stack.push(i);
                
            } 
            
            else {
                
                // pop all the elements till we get a element that is less than the incoming element
                while ( stack.peek() != -1 && heights[stack.peek()] > heights[i]){
                    
                    max = Math.max(max, heights[stack.pop()] * ( i - stack.peek() - 1));
                }
                
                // push the lower height value
                stack.push(i);
            }
            
        }
        
        
        // if the stack is not left with -1 , compute the same for the remaining elements
        while (stack.peek() != -1){

              max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        
        return max;
        
    }
}