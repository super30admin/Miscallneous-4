# Time Complexity :O(N^2) N is numbers of bars in the histogram
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxArea = 0
        
        for i in range(len(heights)):
            minH = float('inf')
            for j in range(i,len(heights)):
                minH = min(heights[j], minH)
                
                width = j - i + 1
                area = width * minH
                maxArea = max(area, maxArea)
                
        
        return maxArea