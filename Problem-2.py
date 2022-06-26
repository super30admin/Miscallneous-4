class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights or len(heights)==0:
            return 0
        n=len(heights)
        stack=[]
        stack.append([-1,-1])
        area=0
        i=0
        while i<n:
            if heights[i]>stack[-1][0]:
                stack.append([heights[i],i])
            else:
                while stack[-1][0] != -1 and stack[-1][0]>heights[i]:
                    top=stack.pop()
                    area=max(area,top[0]*(i-stack[-1][1]-1))
                stack.append([heights[i],i])
            i+=1
        while len(stack)>1:
            top=stack.pop()
            area=max(area,top[0]*(i-stack[-1][1]-1))
            
        return area
                
                
                
        