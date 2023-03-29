#time O(N)
#space O(N)
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        for i in range(len(heights)):
            if not stack:
                stack.append(i)
            else:
                if heights[i] >= heights[stack[-1]]:
                    stack.append(i)
                    continue
                while stack and heights[i] < heights[stack[-1]]:
                    this_bar = stack.pop()
                    right_index = i
                    left_index = stack[-1] if stack else -1 # no lower towards the left, so make it left of the leftmost, which makes it -1
                    area = heights[this_bar] * (right_index - left_index -1)
                    max_area = max(area, max_area)
                stack.append(i)
        while stack:
            this_bar = stack.pop()
            right_index = len(heights) # no lower towards the right, so make it right of the rightmost, which makes it len(heights)
            left_index = stack[-1] if stack else -1
            area = heights[this_bar] * (right_index - left_index -1)
            max_area = max(area, max_area)
        return max_area 
                
        