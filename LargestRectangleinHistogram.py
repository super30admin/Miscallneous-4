# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using monotonous increasing stack to store the indices when the heights are in increasing order.
# Initialize stack with -1
# If the height is smaller than the top of the stack then we resolve all the elements until we find a greater height or stack becomes empty
# If all the heights are in increasing order that is we dont any height greater than top element of the stack then we resolve the stack after we iterate over the heights array


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        stack = []
        stack.append(-1)
        maxwidth = -inf
        for i in range(len(heights)):
            while stack and heights[
                    stack[-1]] >= heights[i] and stack[-1] != -1:
                top = stack.pop()
                maxwidth = max(maxwidth, (heights[top] * (i - stack[-1] - 1)))
            stack.append(i)

        while stack[-1] != -1:
            top = stack.pop()
            maxwidth = max(maxwidth,
                           (heights[top] * (len(heights) - stack[-1] - 1)))
        return maxwidth