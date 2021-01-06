class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int res=0;
        for (int i=0;i<heights.size();i++) {
            int curr=heights[i];
            for (int j=i-1;j>=0;j--) {
               // cout<<heights[j]<<" ";
                if (heights[j]>=heights[i]) {
                     curr+=heights[i];
                } else {
                    break;
                }
            }
            
            for (int j=i+1;j<heights.size();j++) {
                if (heights[j]>=heights[i]) {
                    curr+=heights[i];
                } else {
                    break;
                }
            }
            res=max(res,curr);
        }
        return res;
    }
};