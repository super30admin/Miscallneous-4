// Time Complexity : O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class TopVotedCandidate {
    
    HashMap<Integer, Integer> leaders;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        leaders = new HashMap<>();
        time = times;
        int leader = persons[0];
        
        for(int i = 0; i < persons.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if(count.get(leader) <= count.get(persons[i])) {
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        
        if(leaders.containsKey(t)) {
            return leaders.get(t);
        }
        int low = 0, high = time.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(t > time[mid]) {
                low = mid + 1;
            }
            else if(t < time[mid]) {
                high = mid - 1;
            }
        }
        return leaders.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */