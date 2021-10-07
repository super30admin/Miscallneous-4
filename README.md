# Misc-4

## Problem - 1 Online Election (https://leetcode.com/problems/online-election/)

//time complexity = log(n)
//space complexity = O(1)

class TopVotedCandidate {
    HashMap<Integer, Integer> leaders; 
    int[] time; 
    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap();
        int leader = 0; 
        time = times; 
        HashMap<Integer, Integer> count = new HashMap();
        count.put(0,0); 
        
        for(int i = 0; i < persons.length; i++){
            count.put(persons[i], count.getOrDefault(persons[i],0) + 1);
            int cnt = count.get(persons[i]); 
            if(cnt >= count.get(leader)){
                leader = persons[i]; 
            }
            leaders.put(times[i], leader); 
        }
    }
    
    public int q(int t) {
        if(leaders.containsKey(t)){
            return leaders.get(t); 
        }else{
            int low = 0;
            int high = time.length - 1; 
            
            while(low <= high){
                int mid = low + (high - low) / 2; 

                if(time[mid] > t){
                    high = mid - 1; 
                }else{
                    low = mid + 1; 
                }
            }
            return leaders.get(time[high]);
        }
    }
}


## Problem - 2 Largest Rectangle in histogram (https://leetcode.com/problems/largest-rectangle-in-histogram/)

//time complexity = O(2N)
//space complexity = O(N)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0; 
        Stack<Integer> st = new Stack<>();
        st.push(-1); 
        int max = 0; 
        int i = 0;
       
        while(i < heights.length){
            if(st.peek() == -1 || heights[st.peek()] <= heights[i]){
                st.push(i);
            }else{
                while(st.peek() != -1 && heights[i] < heights[st.peek()]){
                    int top = st.pop(); 
                    max = Math.max(max, heights[top]*(i - st.peek() - 1));
                }
                st.push(i); 
            }
            i++;
        }
        
        while(st.peek() != -1){
            int top = st.pop(); 
                max = Math.max(max, heights[top]*(heights.length - st.peek() - 1));
        }
        
        return max;
    }
}
