#Time O(n), space O(n)
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        m=0
        stack=[]
        i=0
        stack.append(-1)
        
        while i<len(heights):
            if stack[-1]==-1 or heights[i]>heights[stack[-1]]:
                stack.append(i)
            else:
                
                while stack[-1]!=-1 and heights[i]<heights[stack[-1]]:
                    cur=stack.pop()
                    maxc=heights[cur]*(i-stack[-1]-1)
                    m=max(m,maxc)
                    
                stack.append(i)
                i+=1
                
        while stack[-1]!=-1:
            cur = stack.pop()
            maxc=heights[cur]*(i-stack[-1]-1)
            m=max(m,maxc)
                    
        return m
