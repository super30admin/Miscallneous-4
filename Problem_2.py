"""
Time Complexity : O(n)
Space Complexity : O(n)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Here, the brute force way would be to start from the very first height, keep track of minimum and find out that maximum 
height possible with left barrier as first one and right barrier as i which will be increment. Similarly, when we reach the last 
one, start from the second ht and so on. So this is basically an n^2 approach. To make it linear, we would follow the "MONOTONIC 
INCREASING STACK APPROACH". This is the same technique that we used in rising temperature problem. So here, we would keep on
appending the heights to the stack(append only indexes), when the value is greater than the one on top of the stack. Once we
find a ht which is lesser than the one on top, that means that the bigger ht cannot contribute any further, and we start popping
out the values and start calculating the area, and keep a record of the maximum area. I tried with a similar approach, it is basically
doing the same thing, and have commented it.
"""


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [-1]
        maxArea, i = 0, 0
        n = len(heights)
        while i < n:
            if stack[-1] == -1 or heights[i] > heights[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                curr = stack.pop()
                maxArea = max(maxArea, heights[curr]*(i-stack[-1]-1))
        while stack[-1] != -1:
            curr = stack.pop()
            maxArea = max(maxArea, heights[curr]*(i-stack[-1]-1))
        return maxArea

        # heights.append(0)
        # stack = [-1]
        # maxArea,n=0,len(heights)
        # for i in range(len(heights)):
        #     while heights[i] < heights[stack[-1]]:
        #         h = heights[stack.pop()]
        #         w = i - stack[-1] - 1
        #         maxArea = max(maxArea, h * w)
        #     stack.append(i)
        # return maxArea
