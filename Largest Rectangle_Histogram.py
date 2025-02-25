# Approach:
# - We use a **monotonic stack** to efficiently compute the largest rectangle area.
# - The key idea is to determine the **width** of the rectangle using the nearest smaller bar to the left and right.
# - We iterate through `heights` and maintain a stack storing indices of increasing height bars.
# - If we encounter a smaller bar, we **pop from the stack** and compute the area using the popped height as the smallest bar.
# - At the end, we process any remaining bars in the stack to compute their maximum possible rectangle area.

# Time Complexity: O(N) - Each bar is pushed and popped from the stack once.
# Space Complexity: O(N) - Stack stores at most N elements in the worst case.

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []  # Stack to store indices of increasing height bars
        max_area = 0  # Variable to track the maximum rectangle area
        n = len(heights)

        for i in range(n):
            # Maintain an increasing stack; process bars when a smaller bar is encountered
            while stack and heights[i] < heights[stack[-1]]:
                height = heights[stack.pop()]  # Pop the last bar (smallest height in current window)
                width = i if not stack else i - stack[-1] - 1  # Compute width using next smaller element in stack
                max_area = max(max_area, height * width)  # Update max area
            
            stack.append(i)  # Push the current index to stack

        # Process remaining elements in stack (bars extending to the end)
        while stack:
            height = heights[stack.pop()]
            width = n if not stack else n - stack[-1] - 1
            max_area = max(max_area, height * width)

        return max_area  # Return the largest rectangle area found
