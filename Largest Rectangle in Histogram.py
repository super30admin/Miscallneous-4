class Solution:
    #Solution 1
    def largestRectangleArea(self, heights: List[int]) -> int:
        #Approach: Single stack
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of heights
        
        heights.append(0)
        st = []
    
        i = 0
        maxAr = 0

        while i < len(heights):
            if not st or heights[st[-1]] <= heights[i]:
                st.append(i)
                i += 1
            else:
                popped = st.pop()
                ar = heights[popped] * ((i - st[-1] - 1) if st else i)
                maxAr = max(maxAr, ar)
            
        return maxAr
    
    #Solution 2
    """
    def largestRectangleArea(self, heights: List[int]) -> int:
        #Approach: Divide and Conquer
        #Time Complexity: O(n^2)    // sorted input; but O(n log n) in avergae case
        #Space Complexity: O(n)
        #where, n is the length of heights
        
        self.maxAr = 0
        self.helper(heights, 0, len(heights) - 1)
        return self.maxAr
    
    def helper(self, heights, low, high):
        #base
        if low > high:
            return
        
        #logic
        idx = low
        for i in range(low, high + 1):
            if heights[i] < heights[idx]:
                idx = i
                
        self.maxAr = max(self.maxAr, heights[idx] * (high - low + 1))
        self.helper(heights, low, idx - 1)
        self.helper(heights, idx + 1, high)
    """
    
    #Solution 3
    """
    def largestRectangleArea(self, heights: List[int]) -> int:
        #Approach: Brute Force
        #Time Complexity: O(n^2)
        #Space Complexity: O(1)
        #where, n is the length of heights
        
        n = len(heights)
        maxAr = 0
        for i in range(n):
            minHt = inf
            for j in range(i, n):
                minHt = min(minHt, heights[j])
                maxAr = max(maxAr, minHt * (j - i + 1))
                
        return maxAr
    """