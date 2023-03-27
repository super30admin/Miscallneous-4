class Solution {
    
    public int area(int[] heights,int start,int end){
        if(start>end) return 0;
        int min = start;
        for(int i=start;i<=end;i++){
             if(heights[min]>heights[i]) min=i;
        }
        return Math.max(heights[min]*(end-start+1),Math.max(area(heights,start,min-1),area(heights,min+1,end)));
    }
 public int largestRectangleArea(int[] heights) {
        return area(heights,0,heights.length-1);
       }
}