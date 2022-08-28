'''
time complexity: O(n)
space complexity:O(n)
'''
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        st = [-1]
        maxa = 0
        for i in range(len(heights)):
            while(st[-1]!=-1 and heights[st[-1]] >= heights[i] ):
                currHeigh = heights[st.pop()]
                currWidth = i -1 - st[-1]
                maxa = max(maxa,currHeigh*currWidth )  
            st.append(i)
        
        while(st[-1]!=-1):
            currH = heights[st.pop()]
            currW = len(heights) - st[-1] - 1
            maxa = max(maxa,currH*currW ) 
        return maxa