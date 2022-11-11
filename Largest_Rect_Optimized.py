# Time complexity - (2*n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # check for null case
        if not heights or len(heights) == 0:
            return 0
        
        # adding -1 to the stack so that we can get the exact width
        stack = [-1]
        max_area = 0
        n = len(heights)
        
        # start traversing from 0 till n
        for i in range(n):
            # pop the elements and calculate the max area until the stack is not empty and height on top of stack is greater than the incoming height
            while(stack[-1] != -1 and heights[stack[-1]] > heights[i]):
                # calculate the area and find the max
                area = heights[stack.pop()] * (i - stack[-1] - 1)
                max_area = max(max_area, area)
            
            # append the index to the stack
            stack.append(i)
        
        # at the end of the for loop, if we have any elements in the stack, then pop them and find if we can have max area from there
        while stack[-1] != -1:
            area = heights[stack.pop()] * (n - stack[-1] - 1)
            max_area = max(max_area, area)
        
        # return the max area out of all
        return max_area
