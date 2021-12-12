# // Time Complexity :O(n)
# // Space Complexity :O(n),stack space worst case
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        st=[]
        st.append(-1)
        maxar=0
        i=0
        while i <len(heights):
            
            if st[-1]==-1 or heights[i]>heights[st[-1]]:
                st.append(i)
            else:
                while st[-1]!=-1 and heights[i]<heights[st[-1]]:
                    top=st.pop()
                    arr=heights[top]*(i-st[-1]-1)
                    print(arr)
                    maxar=max(maxar,arr)
                st.append(i)
            i+=1
        while st[-1] != -1:
            top=st.pop()
            arr=heights[top]*(i-st[-1]-1)
            print(arr)
            maxar=max(maxar,arr)
            
        return maxar
                
        