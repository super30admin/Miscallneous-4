class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        
        stack = [-1]
        i = 0
        result =0
        while i < len(heights):
            if stack[-1] != -1 and heights[stack[-1]] > heights[i]:
                top = stack.pop()
                result = max(result, heights[top] * (i - stack[-1] -1 ))
            else:
                stack.append(i)
                i+=1
            
        while stack[-1] != -1:
            top = stack.pop()
            result = max(result, heights[top] * (i - stack[-1] -1 ))
            
        
        return result
