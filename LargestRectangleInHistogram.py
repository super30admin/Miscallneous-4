'''
TC: O(n) - where n is the number of elements in the input array
SC: O(n) -  Using stack to store the elements
'''
from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [(-1,-1),]
        mArea = 0
        for i, v in enumerate(heights):
            if v >= stack[-1][1]:
                stack.append((i,v))
            else:
                while v < stack[-1][1]:
                    idx, val = stack.pop()
                    mArea = max(mArea, val*(i-stack[-1][0]-1))
                stack.append((i,v))
        i+=1
        while stack and stack[-1] != (-1,-1):
            idx, val = stack.pop()
            mArea = max(mArea, val*(i-stack[-1][0]-1))
        return mArea
s = Solution()
print(s.largestRectangleArea([2,1,5,6,2,3]))
print(s.largestRectangleArea([2,4]))