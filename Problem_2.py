# Brute force solution 
# Time Complexity: O(n^2)
# Space Complexity: O(n^2)
class Solution(object):
    def largestRectangleArea(self, heights):
        if heights == None or len(heights) == 0:
            return 0;
        result = 0
        for i in range(len(heights)):
            minimum = heights[i]
            for j in range(i, len(heights)):
                minimum = min(minimum, heights[j])
                result = max(result, minimum * (j-i+1))
        return result
        

# Optimized Solution
# Time Complexity: O(2n)
# Space Complexity: O(n)
class Solution(object):
    def largestRectangleArea(self, heights):
        if heights == None or len(heights) == 0:
            return 0;
        result = 0
        stack = deque()
        stack.append(-1)
        i = 0
        while i < len(heights):
            # pop when curr height is smaller than top of the stack
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                top = stack.pop()
                result = max(result, heights[top] * (i - stack[-1] - 1))
            # keep pushing till we are getting larger heights than top of stack
            stack.append(i)
            i+=1
            
        while stack[-1]!= -1:
            top = stack.pop()
            result = max(result, heights[top] * (len(heights) - stack[-1] -1))
        return result
        
        
