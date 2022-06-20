#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [-1]
        maxx = 0
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                temp = stack.pop()
                maxx = max(maxx,heights[temp] * (i-stack[-1] - 1))
            stack.append(i)

        while stack[-1] != -1:
            temp = stack.pop()
            maxx = max(maxx,heights[temp] * (len(heights)-stack[-1] - 1))
            
        return maxx