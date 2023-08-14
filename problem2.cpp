// Time Complexity : O(n)  n = heights.size()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach: stack 

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();

       
        
        vector<int>left(n,0); // to store left lesser element index
        vector<int>right(n,0); // to store right lesser element index
        
        stack<int>st;
        
        // storing left lesser element indices
        for(int i = 0;i<n;i++)
        {
            while(!st.empty() && heights[st.top()] >= heights[i])
            {
                st.pop();
            }
            if(st.empty()){
                left[i] = -1;
            }
            else{
                left[i] = st.top();
            }
            st.push(i);
        }
        
        st = stack<int>();
        
        
        // storing right lesser element indices
        for(int i = n-1;i>=0;i--)
        {
            while(!st.empty() && heights[st.top()] >= heights[i])
            {
                st.pop();
            }
            if(st.empty()){
                right[i] = n;
            }
            else{
                right[i] = st.top();
            }
            st.push(i);
        }
        
        int ans = 0;
        
        
        for(int i = 0;i<n;i++)
        {
            ans = max(ans, heights[i]*(right[i]-left[i]-1));
        }

        return ans;
    }
};



// Another Solution 

//idea is to calculate the same as above directly, instead of storing them in the array.



class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        
        int maxValue = 0;
        stack<int>st;
        st.push(-1);
        
        int i = 0;
        
        while(i<n)
        {
            if(st.top()==-1 || heights[i]>=heights[st.top()])
            {
                st.push(i);
                i++;
            }
            else{
                int p = st.top();st.pop();
                maxValue = max(maxValue, heights[p]*(i-st.top()-1));
            }
        }
        while(st.size()>1){
            int p = st.top();st.pop();
            maxValue = max(maxValue, heights[p]*(i-st.top()-1));
        }
        
        return maxValue;
    }
};