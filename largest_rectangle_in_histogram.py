class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        ## T.C = O(n)
        ## S.C = O(n)

        ar = 0
        n = len(heights)
        i = 0
        stack = [-1]

        while i < n:
            if stack[-1] == -1 or heights[i] >= heights[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                x = stack.pop(-1)
                height = heights[x]
                width = i - stack[-1] - 1
                ar = max(ar, height*width)

            
        while len(stack) > 1:
            x = stack.pop(-1)
            height = heights[x]
            width = i - stack[-1] - 1
            ar = max(ar, height*width)

        return ar