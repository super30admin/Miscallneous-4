/*

We are given a histogram consisting of bars , each bar is of fixed width , we need to find the largest area of a rentangle if the bar can be expanded

The bar can be expanded if a bigger height bar is next to it (or before it). The expansion can be from left to right

There is going to be a left boundary , and a right boundary

lets assume that the left bounday index for the very first element is -1 , and the right boundary for the very last element is the length of the array

Intuition:

We can solve this using a monotonic increasing stack. In monotonic increasing stack, only the increasing values can be there.

We will keep putting the values in the stack, as soon as a lower height bar is appeared, lets call it 's' we know that the higher bar cannot be expanded more , so we need to resolve it 

When we resolve a height , we consider its left boundary, as an element that just appeared before it, the right boundary as the smaller element 's' that wwe ecnountered and we calculate its area
area can be calculated by this formula = > height * (number of bars)
more specifically it would be 

height * (index of the lower element 's'(right boundary) - (index of the element on the top of the stack) (left boundary) -1) 

The -1 is coming because the smaller element 's' is not included, 

One thing to note is that it will always be this case for the element taht just got popped out
1) left element is always going to be smaller ( monotonic increasing)
2) right element is always going to be bigger ( monotonic increasing)

It will never be the case that the left is bigger than then the elment , because we are only putting elements in the increasing order

We will keep on popping the elements which are bigger than the 's' and keep in resolving them and then push the 's' inside the stack and continue with the flow

At the end if there are still elements in the stack, then we will take lastindex+1 as the right boundary  , and keep on resolving them until we hit the bottom

Time : O (n)
Space : O(n)
*/

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1); // left boundary 
        int max =0;

        for(int i=0;i<n;i++){
            // if current element is less than the element on the top of the stack then keep resolving all the elements in the stack which are larger than this, because they cannot be expanded further
            
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                // resolve the ones which are bigger
                int res = heights[stack.pop()] * ( i - (stack.peek()) - 1);
                max = Math.max(max,res);
            }
            stack.push(i);
        }

        // if there are elements still remaining then resolve them
        // taking the last index +1 as the right boundary

        while(!stack.isEmpty() && stack.peek()!=-1){
        int res = heights[stack.pop()] * ( n - (stack.peek()) - 1); // the n as taken as the index of the smallest value
                max = Math.max(max,res);
        }

        return max;
        
    }
}