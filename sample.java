//Problem 1: Online Election
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// add person votes at that given timestamp, and check if he is the new leader, if yes, change leader value and put in timemap suchthat we can get at what time, who was the leader
class TopVotedCandidate {
    Map<Integer, Integer> map;
    int[] tim;
    public TopVotedCandidate(int[] persons, int[] times) { //O(n)
        this.tim=times;
        int leader=persons[0];
        this.map=new HashMap<>();
        Map<Integer, Integer> Countmap=new HashMap<>();
        for(int i=0;i<persons.length;i++){
            int person=persons[i];
            int time=times[i];
            Countmap.put(person,Countmap.getOrDefault(person,0)+1);
            if(Countmap.get(person)>=Countmap.get(leader)){
                leader=person;
            }
            map.put(time,leader);
        }
    }
    
    public int q(int t) { //O(log(high-low))
        if(map.containsKey(t)) return map.get(t);
        else{
            int low=0,high=tim.length-1;
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if(tim[mid]>t){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return map.get(tim[high]);
        }
    }
}

//Problem 2: Largest rectangle in a histogram
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// if incoming histogram is smaller than the current one, we now can have a rectangle, consider that rectangle and move ahead.
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0|| heights==null) return 0;
        Stack<Integer> st= new Stack<>();
        int max=0;
        int n=heights.length;

        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && heights[i]<heights[st.peek()]){
                //resolve
                int pop=st.pop();
                max=Math.max(max, heights[pop]*(i-st.peek()-1));
            }
            st.push(i);
        }
        //pending elements resolve
        while(st.peek()!=-1){
                //resolve
                int pop=st.pop();
                max=Math.max(max, heights[pop]*(n-st.peek()-1));
            }
        return max;
    }
}