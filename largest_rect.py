# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        stack.append(-1)
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                ht = heights[stack.pop()]
                wt = i - stack[-1] - 1
                max_area = max(max_area, ht*wt)
            stack.append(i)
        while stack[-1] != -1:
            ht = heights[stack.pop()]
            wt = len(heights) - stack[-1] - 1
            max_area = max(max_area, ht*wt)
        return max_area
