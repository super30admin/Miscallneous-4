//Time:O(2n) where n is the size of the heights
//Space: O(n) size of the stack
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if(heights.size() == 1) return heights[0];
        stack<int> stk;
        stk.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.size(); i++){
            while(stk.top() != -1 and heights[i] < heights[stk.top()]){
                int top = stk.top();
                stk.pop();
                maxArea = max(maxArea,(int)(heights[top]*(i-stk.top()-1)));
            }
            stk.push(i);
        }
        while(stk.top() != -1){
            int top = stk.top();
            stk.pop();
            maxArea = max(maxArea,(int)(heights[top]*(heights.size()-stk.top()-1)));
        }
        return maxArea;
    }
};