# Time Complexity :O(N) N is numbers of bars in the histogram
# Space Complexity :O(N) N is numbers of bars in the histogram
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        if n == 0: return 0
        stack = []
        maxArea = 0
        stack.append(-1)
        for i in range(n):
            if stack[-1] == -1 or heights[i] >= heights[stack[-1]]:
                stack.append(i)
            else:
                while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                    pIndex = stack.pop()
                    area = heights[pIndex] * (i - stack[-1] - 1)
                    maxArea = max(area, maxArea)
                stack.append(i)
                    
        while stack[-1] != -1:
            pIndex = stack.pop()
            area = heights[pIndex] * (n - stack[-1] - 1)
            maxArea = max(area, maxArea)
            
        return maxArea