#include<iostream>
#include<stack>
#include<vector>

using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int max_val{};
        stack<int> st{};
        st.push(-1);
        size_t sz{heights.size()};
        int i{};
        for(;i<sz;++i){
            while(st.top()!=-1 && heights.at(st.top())>heights.at(i)){
                int idx = st.top();
                st.pop();
                max_val = max(max_val,heights.at(idx)*(i-1-st.top()));
            }
            st.push(i);
        }
        while(st.top()!=-1){
            int idx = st.top();
            //cout<<idx<<" ";
            st.pop();
            max_val = max(max_val,heights.at(idx)*(i-1-st.top()));
        }
        return max_val;
    }
};