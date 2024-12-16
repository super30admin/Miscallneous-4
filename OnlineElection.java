// Logic -
// we need to determine the leader at each stage
// searching for the leader is O(1), thanks to the hashmap.
// searching for the time say q(12) happens due to the binary search on the times array which happens in log(n) time.

import java.util.HashMap;
import java.util.Map;

class TopVotedCandidate {
    HashMap<Integer, Integer> map;
    int[] times;

    // Time complexity = O(n). filling the hashmap
    // Space complexity = O(n). the hashmap.
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int leader=0;
        map = new HashMap<>();
        Map<Integer, Integer> leaderMap = new HashMap<>();
        for(int i=0;i< times.length;i++) {
            leaderMap.put(persons[i], leaderMap.getOrDefault(persons[i], 0) + 1);
            if(leaderMap.get(leader) <= leaderMap.get(persons[i])) {
                leader = persons[i];
            }
            map.put(times[i], leader );
        }
    }
    
    // Time complexity = O(log(n)). for the binary search
    // Space complexity = O(1).
    public int q(int t) {
        if(map.containsKey(t)) {
            return map.get(t);
        }
        int low=0;
        int high=times.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(times[mid]< t) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return map.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */