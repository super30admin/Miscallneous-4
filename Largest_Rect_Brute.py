# Time complexity : O(n*n)
# Space complexity : O(1)
# Leetcode : TLE

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # check for the null case
        if not heights or len(heights) == 0:
            return 0
        
        # declare variable to store the max_area and find the len of heights
        max_height = 0
        n = len(heights)
        
        # traverse from 0 to n
        for i in range(n):
            # min height that we can have starts from the current height
            min_height = heights[i]
            for j in range(i,n):
                # find the min between all the heights starting from i
                min_height = min(min_height, heights[j])
                
                # find the max aread with the min height and the width
                max_height = max(max_height, min_height*(j-i+1))
        
        # return the max area
        return max_height
