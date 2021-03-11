//Time - O(n)
//Space - O(n)
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<pair<int,int>> st;
        int i = 1;
        int ans = heights[0];
        st.push({0,heights[0]});
        while(i<heights.size()){
            
            if(st.top().second<heights[i]){
                st.push({i,heights[i]});
                
            }else{
                int idx, val;
                while(!st.empty() && st.top().second>=heights[i]){
                    idx = st.top().first;
                    val = st.top().second;st.pop();
                    ans = max(ans, val*(i-idx));
                }
                
                st.push({idx, heights[i]});
                
            }
            i++;
        }
        
        while(!st.empty()){
            int idx = st.top().first;
            int val = st.top().second;st.pop();
            ans = max(ans, val*(i-idx));
        }
        
        return ans;
    }
};