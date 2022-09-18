""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:

        n = len(heights)
        if heights == None or n == 0:
            return 0
        st = [-1]
        maxim = float('-inf')
        for i in range(n):
            while st[-1] != -1 and heights[i] < heights[st[-1]]:
                temp = st.pop()
                maxim = max(maxim, heights[temp] * (i - st[-1] - 1))
            st.append(i)
        while st[-1] != -1:
            temp = st.pop()
            maxim = max(maxim, heights[temp] * (n - st[-1] - 1))
        return maxim
