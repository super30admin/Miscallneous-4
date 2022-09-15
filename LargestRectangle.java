//Time O(n)
// Space O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each element h of heights, we need to keep track of the furthest element to its right with height greater than or equal to h and the farthest element to the left with height greater than or equal to h. this means we have 2 arrays, one to store the farthest left element and one to store the farthest right element. Now for each index i of the height array , the max area for that index would be height[i]* (right[i]-left[i]-1).
        
        int n = heights.length;
        int [] right = new int[n];
        int [] left= new int[n];
        left[0]=-1;
        right[n-1]=n;
        
        for(int i =1;i<n;i++)
        {
            int h = heights[i];
            int p = i-1;
      
            while(p>=0 && heights[p]>=h)
            {
                p = left[p];
                
            }
      
            left[i]=p;
        }

        for(int i =n-2;i>=0;i--)
        {   int h= heights[i];
            int p = i+1;
            while(p<n && heights[p]>=h)
            {
                p=right[p];
            }
           right[i]=p;
        }
        int area= 0;
        
        for(int i =0;i<n;i++)
        {
            area =Math.max(area, heights[i]* (right[i]-left[i]-1));
        }
        return area;
            

      
    }
}





