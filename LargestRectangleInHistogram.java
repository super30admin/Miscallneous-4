//Brute Force
class Solution {

    //Time Complexity: 0(n^2) where n is the no. of elements in my heights array
    //Space Complexity: 0(1)

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int max = 0;    //initially setting my max to null

        for(int i = 0; i < heights.length; i++){    //starts from 1st index and goes up till length
            int min = heights[i];   //taking the min height as the current index
            for(int j = i; j < heights.length; j++){    //starts from i and goes up till length
                min = Math.min(min, heights[j]);    //computing min or the area for the current histogram only
                max = Math.max(max, min * (j - i + 1)); //computing the max area between previous max or the area between i to j and height.(Min gives the height). Did + 1 because width will be always 1 atleast
            }
        }

        return max; //returning max
    }
}

//Optimization- Monotonic Stack

class Solution {

    //Time Complexity: 0(n) where n is the no. of elements in the heights array
    //Space Complexity: 0(n)

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }

        int max = 0;    //keeps a track of the max area of rectangle
        Stack<Integer> s = new Stack<>();   //a monotonic increasing stack. I push my heights in increasing order
        s.push(-1); //pushing -1 initially
        int i = 0;  //pointer that navigates the heights array

        while(i < heights.length){
            if(s.peek() == -1 || heights[i] >= heights[s.peek()]){  //if I am not staring at an empty stack or if my current height is greater than the height at the top of the stack
                s.push(i);  //then I push on to my stack
                i++;    //also increase the pointer
            }
            else{
                max = Math.max(max, heights[s.pop()] * (i- s.peek() - 1));  //otherwise, I pop the top element from the stack and calculate the area
            }
        }

        while(s.size() > 1){
            max = Math.max(max, heights[s.pop()] * (i- s.peek() - 1));  //there might come a time when stack is not empty, so I keep popping and checking the max area until only -1 is left in the stack
        }

        return max; //return max at the end
    }
}