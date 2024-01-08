// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class TopVotedCandidate {

    HashMap<Integer, Integer> leaders;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.time = times;
        this.leaders = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int leader = 0;
        for(int i = 0; i < persons.length; i++){
            int p = persons[i];
            int t = times[i];
            count.put(p, count.getOrDefault(p, 0) + 1);
            if(count.get(p) >= count.get(leader)){
                leader = p;
            }
            leaders.put(t, leader);
        }    
    }
    
    public int q(int t) {
        if(leaders.containsKey(t))
            return leaders.get(t);
        int low = 0;
        int high = time.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(time[mid] > t){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int nearestSmallerTime = time[high];
        return leaders.get(nearestSmallerTime);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */