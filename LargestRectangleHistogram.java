// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using Stack
public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length==0)
            return 0;
        
        int max=0;
        int local=0;
        
        int i=0;
        Stack<Integer> stack = new Stack<>();
        while(i< heights.length){
            //case1
            if(stack.isEmpty() || heights[i] > heights[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int top = stack.pop();
                local = 0;
                if(stack.isEmpty()){
                    local =  heights[top] * i;
                }else{
                    local = heights[top] * (i-stack.peek() -1);
                }
                max = Math.max(max, local);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()){
                local =  heights[top] * i;
            }else{
                local = heights[top] * (i-stack.peek() -1);
            }
            max = Math.max(max, local);  
        }
        return max;
        
    }

