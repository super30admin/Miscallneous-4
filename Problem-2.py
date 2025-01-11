#Approach
#its is like monotonic stack pattern we need to resolve the stack untill the we find the less heught calcultae the area


#Complexities
#Time: O(n)
#Space: O(n)

from typing import List


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [-1]

        result = float("-inf")
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                popped = stack.pop(-1)
                result = max(result, heights[popped] * (i - stack[-1] - 1))

            stack.append(i)

        while stack[-1] != -1:
            popped = stack.pop()
            result = max(result, heights[popped] * (len(heights) - stack[-1] - 1))
        return result
