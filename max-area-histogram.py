# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        st = [-1]
        heights.append(0)
        maxarea = 0
        for i in range(len(heights)):
            while st and heights[i] < heights[st[-1]]:
                idx = st.pop()
                height = heights[idx]
                width = i - st[-1] - 1
                maxarea = max(maxarea, height*width)
            st.append(i)
            
        return maxarea