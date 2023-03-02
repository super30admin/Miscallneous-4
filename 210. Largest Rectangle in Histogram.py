class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if heights is None or len(heights) == 0:
            return 0

        self.max = 0
        st = list()
        st.append(-1)

        i = 0

        while i < len(heights):
            if st[-1] == -1 or heights[i] > heights[st[-1]]:
                st.append(i)
            else:
                while heights[st[-1]] > heights[i] and st[-1] != -1:
                    top = st.pop()
                    self.max = max(self.max, heights[top] * (i - st[-1] - 1))
                st.append(i)
            i += 1

        while st[-1] != -1:
            top = st.pop()
            self.max = max(self.max, heights[top] * (i - st[-1] - 1))
        return self.max

# Monotonic Stack
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
