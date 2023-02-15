// Approach 1: Brute force

// Time complexity: O(n^2)
// Space complexity: O(1)

// Go over every possible combination and calculate the max area 

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if(heights.size() == 0)
            return 0;
        int result = 0;
        for(int i = 0; i<heights.size(); i++) {
            int minHeight = heights[i];
            for(int j = i; j<heights.size(); j++) {
                minHeight = min(minHeight, heights[j]);
                result = max(result, minHeight * (j-i+1));
            }
        }
        return result;
    }
};


// Approach 2: Monotonic increasing stack

// Time complexity: O(n)
// Space complexity: O(n)


class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if(heights.size() == 0)
            return 0;
        int result = 0;
        stack<int> s;
        s.push(-1);
        int i = 0;
        while(i < heights.size()) {
            // if the stack is empty (i.e has only -1 or the number is smaller than the current number - just push it)
            if(s.top() == -1 || heights[i] >= heights[s.top()]) {
                s.push(i);
                i++;
            }
            // calculate the new area and update result 
            // to calculate the new area -> the current number we have seen is the smallest height we have seen till now (if it wasn't - we would have simply pushed it into the stack)
            // so the top height * (current index - the index on the top of the stack after the current -1)
            // Stack currently when it seens i = 4 (height = 2)
            // Ex: -1, 1, 2, 3
            //      -, 1, 5, 6  
            // The top of the stack is 6 and the current is 2. We want to resolve all the numbers bigger than 2
            // Pop 6 -> This is the smallest height we've seen till now (while popping)
            // area = 6 * (width)
            // Width = i - 2 -1 and not i - 3 -1 -> instead of the i for top of the stack, take the i of the next number which forms the boundary - say we had a popped a bnunch of indices in the middle (that means they were definitley bigger than the current height we are seeing. So the min_height will still hold true and we can calculate the correct width)
            else {
                int top = s.top();
                int popped = heights[top];
                s.pop();
                int area = popped * (i - s.top() - 1);
                result = max(area, result);
            }
        }

        // we might still have elements in the stack that haven't been popped yet - resolve all of them and update the result
        while(s.size() > 1) {
            int top = s.top();
            int popped = heights[top];
            s.pop();
            int area = popped * (i - s.top() - 1);
            result = max(area, result);
        }
        return result;
    }
};