# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#BRUTE FORCEEEEEE
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        mx = 0
        for i in range(len(heights)):
            mn = float('inf')
            for j in range(i, len(heights)):
                mn = min(mn, heights[j])
                mx = max(mx, mn*(j-i+1))

        return mx
#BETTER SOLUTION
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        #monotonic increasing stack
        if not heights:
            return 0
        mx = 0
        stack = [-1]
        
        i=0
        while i < len(heights):
            if stack[-1] == -1 or heights[i] >= heights[stack[-1]]:
                stack.append(i)
                i += 1
            #needa resolve
            else:
                top = stack.pop()
                mx = max(mx, heights[top] * (i-stack[-1]-1))
                
        while stack[-1] != -1:
            top = stack.pop()
            mx = max(mx, heights[top] * (i-stack[-1]-1))
        return mx